package controller;

//import com.alipay.zdal.client.ThreadLocalString;
//import com.alipay.zdal.client.jdbc.ZdalDataSource;
//import com.alipay.zdal.client.util.ThreadLocalMap;
//import com.alipay.zdal.client.util.condition.DBSelectorIDRouteCondition;
import constants.BlogConstants;
import job.BlogViewLogJob;
import mapper.BlogContextMapper;
import mapper.BlogMapper;
import model.Blog;
import model.BlogContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import service.BlogService;
//import util.BlogComparator;
//import util.ZdalRuleParser;
//import util.BlogUtil;
import util.BlogUtil;
import vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Taohaowei on 2017/7/26.
 */
@Controller("blogController")
public class BlogController {


    private Logger logger = LoggerFactory.getLogger(BlogController.class);

    @RequestMapping("uploadBlog.html/{password}")
    public String turnUploadBlog(@PathVariable(name = "password") String password) throws Exception {
        if(BlogConstants.PASSWORD.equals(password)){
            return "uploadBlog";
        }else{
            throw new Exception("密码错误");
        }
    }


    @Autowired
    private BlogService blogService ;

    @RequestMapping("myshow.html")
    public String turnmyshow()
    {
        return "myshow";
    }

    @RequestMapping("insert.html")
    public String insertBlog(Blog blog,String typeName, HttpServletRequest request)
    {
        String path = request.getSession().getServletContext().getRealPath("blog");
        //设置博客类型
        setBlogType(blog,typeName);
        //插入博客，并返回插入博客id
        int blogId = 1;
        try {
            blogId = blogService.insert(blog,path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/blog/toNextBlog.html?blogId="+blogId;
    }

    @RequestMapping("toNextBlog.html")
    public String toNextBlog(int blogId, HttpServletRequest request, Model model) throws Exception {
        logger.info("toNextBlog方法执行");
        //根据博客id查询得到博客，存入model
        Blog blogById = blogService.findBlogById(blogId);
        Blog preBlog = blogService.findNextBlogById(blogId+1);
        Blog nextBlog = blogService.findNextBlogById(blogId-1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        model.addAttribute("sdf",sdf);
        model.addAttribute("preBlog",preBlog);
        model.addAttribute("blog",blogById);
        model.addAttribute("nextBlog",nextBlog);
        return "single";
    }


    @RequestMapping("")
    public String loadIndex(PageVO pageVO, Model model)
    {
//        System.out.println("dateSource = "+dataSource==null);
        pageVO = new PageVO(pageVO.getNowPage(),blogService.countListSize(),6);
        //逻辑数据库初始化加载
        //开始查询
        List<Blog> blogList = blogService.findAllBlog(pageVO.getBegin(),pageVO.getPageSize());
        //根据时间规则排序
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("sdf",sdf);
        model.addAttribute("pageVO",pageVO);
        model.addAttribute("blogList",blogList);

        return "index";
    }

    @ExceptionHandler({Exception.class})
    public String exceptionHandler(HttpServletRequest request, Exception e)
    {
        e.printStackTrace();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        request.setAttribute("date",sdf.format(new Date()));
        return "error";
    }


    @Autowired
    private BlogViewLogJob blogViewLogJob;

    @RequestMapping("asdasdasd.html")
    public void updateViewLog()
    {
        blogViewLogJob.doJob();
    }
//    @Autowired
//    private BlogMapper blogMapper;
//    @Autowired
//    private BlogContextMapper blogContextMapper;
//
//    /**
//     * 用于转存储，将数据库内容博客转换成文件形式存储.
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping("dataSourceBlogTofile")
//    public String dataSourceBlogTofile() throws IOException {
//        List<Blog> allBlog = blogMapper.findAllBlog(0, 1000);
//        for (Blog blog : allBlog) {
//            blogContextMapper.insert(new BlogContext(blog.getId(), blog.getContext()));
////            BlogUtil.strSaveToFile(blog.getContext(),"H:\\ideaWorkSpace\\blog\\entrance\\web\\src\\main\\resources\\static\\blog\\"+blog.getId()+".html");
//            blog.setContext(blog.getId()+".html");
//            blogMapper.updateBlog(blog);
//        }
//        return "redirect:";
//     }

//Zdal的首页方法
//    @Autowired
//    private ZdalDataSource dataSource;
// 所有配置的物理数据源, dbIndex
//    private Map<Integer, String> logicPhysicsIndexes;

//库名
//表名
//    @RequestMapping("loadIndex.html")
//    public String loadIndex(PageVO pageVO, Model model)
//    {
////        System.out.println("dateSource = "+dataSource==null);
//        //逻辑数据库初始化加载
//        logicPhysicsIndexes = new HashMap<Integer, String>();
//        //得到物理数据源名称
//        Map<String, String> logicPhysicsDsNames = dataSource.getZdalConfig().getLogicPhysicsDsNames();
//        //将其存入物理数据源数据  {(0,master_00),(1,master_01)...}
//        for (String name : logicPhysicsDsNames.keySet()) {
//            String[] split = name.split("_");
//            logicPhysicsIndexes.put(Integer.valueOf(split[1]), name);
//        }
//        //开始查询
//        List<Blog> blogList = new ArrayList<Blog>();
//        for(int i=0;i<4;i++)
//        {
//            // 指定查詢库的路由規則
//            //根据规则得到分库索引
//            int dbIndex = ZdalRuleParser.parserDbIndex(i);
//            String dbSelectorID = logicPhysicsIndexes.get(dbIndex);
////            System.out.println("dbSelectorID = " + dbSelectorID);
//            //根据规则得到分表索引
//            int tbIndex = ZdalRuleParser.parserTbIndex(i);
//            String tablePostfix = new DecimalFormat("_00").format(tbIndex);//如果tbIndex为3，tablePostfix为_03
//            //根据分表索引得到物理表名称
//            String physicTableName = "t_blog" + tablePostfix;
////            System.out.println("physicTableName = " + physicTableName);//physicTableName = t_city_00、t_city_01、t_city_02等
//            //得到 数据库选择器标识路由条件---确定是存在哪一个数据库中
//            DBSelectorIDRouteCondition dbSelectorIDRouteCondition = new DBSelectorIDRouteCondition("t_blog", dbSelectorID, physicTableName);
//            //将分库分表添加到线程中
//            ThreadLocalMap.put(ThreadLocalString.ROUTE_CONDITION, dbSelectorIDRouteCondition);
//
//            List<Blog> allBlog = blogService.findAllBlog();
//            blogList.addAll(allBlog);
//        }
//        //根据时间规则排序
//        Collections.sort(blogList,new BlogComparator());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        System.out.println("pageVO1 = "+pageVO);
//        pageVO = new PageVO(pageVO.getNowPage(),blogList.size(),6);
//
//        System.out.println("pageVO2 = "+pageVO);
//
//        model.addAttribute("sdf",sdf);
//        model.addAttribute("pageVO",pageVO);
//        model.addAttribute("blogList",blogList);
//
//        return "index";
//    }

    private void setBlogType(Blog blog, String typeName)
    {
        if("原创".equals(typeName))
        {
            blog.setType(1);
        }else if("转载".equals(typeName))
        {
            blog.setType(2);
        }else if("翻译".equals(typeName))
        {
            blog.setType(3);
        }else if("收藏".equals(typeName))
        {
            blog.setType(4);
        }
    }


}
