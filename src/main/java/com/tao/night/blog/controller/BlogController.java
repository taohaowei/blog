package com.tao.night.blog.controller;

import com.tao.night.blog.controller.vo.PageVO;
import com.tao.night.blog.dao.BlogContextDAO;
import com.tao.night.blog.dao.model.BlogContextDO;
import com.tao.night.blog.dao.model.BlogDO;
import com.tao.night.blog.service.BlogService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Taohaowei on 2017/7/26.
 */
@Controller
public class BlogController {

    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5MB
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogContextDAO blogContextDAO;

    @PostMapping("/uploadFile")
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "上传的文件为空");
            return "errorPage";
        }

        // 验证文件大小
        if (file.getSize() > MAX_FILE_SIZE) {
            model.addAttribute("message", "上传的文件大小超过限制");
            return "errorPage";
        }

        // 验证文件类型（这里只允许图片类型）
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            model.addAttribute("message", "文件类型不支持");
            return "errorPage";
        }

        // 获取上传路径
        String uploadDir = request.getServletContext().getRealPath("/blogImg");
        if (StringUtils.isBlank(uploadDir)) {
            uploadDir = System.getProperty("java.io.tmpdir");
        }

        // 生成安全的文件名
        String originalFileName = file.getOriginalFilename();
        String fileName = System.currentTimeMillis() + "_" + org.springframework.util.StringUtils.cleanPath(originalFileName);
        File targetFile = new File(uploadDir, fileName);

        // 确保目录存在
        if (!targetFile.getParentFile().exists()) {
            boolean mkdirs = targetFile.getParentFile().mkdirs();
            if (!mkdirs) {
                model.addAttribute("message", "目录创建失败");
                return "errorPage";
            }
        }

        // 保存文件
        try {
            file.transferTo(targetFile);
            model.addAttribute("fileUrl", request.getContextPath() + "/blogImg/" + fileName);
            return "uploadBlog";
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "文件上传失败");
            return "errorPage";
        }
    }

    @GetMapping("/insert")
    public String insertBlog(BlogDO blogDO, @RequestParam("typeName") String typeName, Model model) {
        if (blogDO == null || StringUtils.isBlank(typeName)) {
            model.addAttribute("message", "博客内容或类型不能为空");
            return "errorPage";
        }

        // 设置博客类型
        if (!setBlogType(blogDO, typeName)) {
            model.addAttribute("message", "未知的博客类型");
            return "errorPage";
        }

        // 插入博客
        try {
            Long blogId = blogService.insert(blogDO, blogDO.getContext());
            return "redirect:/toNextBlog?blogId=" + blogId;
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "博客插入失败");
            return "errorPage";
        }
    }

    @GetMapping("/toNextBlog")
    public String toNextBlog(@RequestParam("blogId") Long blogId, Model model) {
        if (blogId == null || blogId <= 0) {
            model.addAttribute("message", "无效的博客ID");
            return "errorPage";
        }

        try {
            // 获取当前博客
            BlogDO blogDOById = blogService.findBlogById(blogId);
            if (blogDOById == null) {
                model.addAttribute("message", "博客不存在");
                return "errorPage";
            }

            BlogContextDO blogContextDO = blogContextDAO.selectById(blogDOById.getId());
            blogDOById.setContext(blogContextDO.getContext());

            // 获取上一条和下一条博客
            BlogDO preBlogDO = blogService.findNextBlogById(blogId + 1);
            BlogDO nextBlogDO = blogService.findNextBlogById(blogId - 1);

            // 判断是否为旧博客
            Date thresholdDate = new SimpleDateFormat("yyyy-MM-dd").parse("2017-07-03");
            boolean isOldBlog = blogDOById.getCreateTime().before(thresholdDate);

            model.addAttribute("isOldBlog", isOldBlog);
            model.addAttribute("dateFormat", DATE_FORMAT);
            model.addAttribute("preBlogDO", preBlogDO);
            model.addAttribute("blogDO", blogDOById);
            model.addAttribute("nextBlogDO", nextBlogDO);
            return "single";
        } catch (ParseException e) {
            e.printStackTrace();
            model.addAttribute("message", "日期解析失败");
            return "errorPage";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "加载博客失败");
            return "errorPage";
        }
    }

    @GetMapping("/")
    public String redirectToLoadIndex() {
        return "redirect:/loadIndex";
    }

    @GetMapping("/loadIndex")
    public String loadIndex(
            @RequestParam(value = "nowPage", required = false, defaultValue = "1") Integer nowPage,
            Model model) {
        if (nowPage == null || nowPage < 1) {
            nowPage = 1;
        }

        // 获取总记录数
        int totalRecords = blogService.countListSize().intValue();
        PageVO pageVO = new PageVO(nowPage, totalRecords, 6);

        // 检查当前页是否超出范围
        if (nowPage > pageVO.getPageCount()) {
            nowPage = pageVO.getPageCount();
            pageVO.setNowPage(nowPage);
        }

        // 查询博客列表
        List<BlogDO> blogDOList = blogService.findAllBlog(pageVO.getBegin(), pageVO.getPageSize());

        model.addAttribute("dateFormat", DATE_FORMAT);
        model.addAttribute("pageVO", pageVO);
        model.addAttribute("blogDOList", blogDOList);

        return "index";
    }

    @GetMapping("/myshow")
    public String myShow() {
        return "myshow"; // 返回模板名称，不需要加 .html 后缀
    }
    private boolean setBlogType(BlogDO blogDO, String typeName) {
        if (blogDO == null || StringUtils.isBlank(typeName)) {
            return false;
        }

        switch (typeName) {
            case "原创":
                blogDO.setType(1);
                break;
            case "转载":
                blogDO.setType(2);
                break;
            case "翻译":
                blogDO.setType(3);
                break;
            case "收藏":
                blogDO.setType(4);
                break;
            default:
                return false;
        }
        return true;
    }
}
