//import com.alipay.zdal.client.ThreadLocalString;
//import com.alipay.zdal.client.jdbc.ZdalDataSource;
//import com.alipay.zdal.client.util.ThreadLocalMap;
//import com.alipay.zdal.client.util.condition.DBSelectorIDRouteCondition;
//import com.tao.mapper.BlogMapper;
//import com.tao.model.Blog;
//import com.tao.service.BlogService;
//import com.tao.util.BlogComparator;
//import com.tao.util.ZdalRuleParser;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
///**
// * Created by Taohaowei on 2017/7/26.
// */
//public class BlogServiceTest {
//    private BlogService service;
//    private BlogMapper blogMapper;
//    private ZdalDataSource dataSource;
//    // 所有配置的物理数据源, dbIndex
//    private Map<Integer, String> logicPhysicsIndexes;
//
//    //库名
//    private String dbName = "blog";
//    //表名
//    private String tbName = "t_blog";
//    @Before
//    public void init()
//    {
//        //加载spring容器，实例化bean
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        service = (BlogService) context.getBean("blogService");
//        dataSource = (ZdalDataSource) context.getBean("dataSource");
//        blogMapper = (BlogMapper) context.getBean("blogMapper");
//        //实例化逻辑数据源
//        logicPhysicsIndexes = new HashMap<Integer, String>();
//        //得到物理数据源名称
//        Map<String, String> logicPhysicsDsNames = dataSource.getZdalConfig().getLogicPhysicsDsNames();
//        //将其存入物理数据源数据  {(0,master_00),(1,master_01)...}
//        for (String name : logicPhysicsDsNames.keySet()) {
//            String[] split = name.split("_");
//            logicPhysicsIndexes.put(Integer.valueOf(split[1]), name);
//        }
//    }
//    @Test
//    /**
//     * 插入数据库操作
//     */
//    public void insert(){
////        设置插入10条id数据，id自增
//        for (int id=1;id<26;id++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            // 指定查詢库的路由規則
//            //根据规则得到分库索引
////            int dbIndex = ZdalRuleParser.parserDbIndex(id);
////            String dbSelectorID = logicPhysicsIndexes.get(dbIndex);//System.out.println("dbSelectorID = " + dbSelectorID);
////            //根据规则得到分表索引
////            int tbIndex = ZdalRuleParser.parserTbIndex(id);
////            String tablePostfix = new DecimalFormat("_00").format(tbIndex);//如果tbIndex为3，tablePostfix为_03
////            //根据分表索引得到物理表名称
////            String physicTableName = tbName + tablePostfix;// System.out.println("physicTableName = " + physicTableName);//physicTableName = t_city_00、t_city_01、t_city_02等
////            //得到 数据库选择器标识路由条件---确定是存在哪一个数据库中
////            DBSelectorIDRouteCondition dbSelectorIDRouteCondition = new DBSelectorIDRouteCondition("t_blog", dbSelectorID, physicTableName);
////            //将分库分表添加到线程中
////            ThreadLocalMap.put(ThreadLocalString.ROUTE_CONDITION, dbSelectorIDRouteCondition);
//
//            System.out.println("配置完成，准备开始插入数据");
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Calendar calendar = Calendar.getInstance();
//            Date date = calendar.getTime();
//            System.out.println(date);
//            Blog blog = new Blog("java中JVM的原理","一、Java虚拟机的生命周期",new Date(),1,"blogType",1,1,"文章实际内容","sumimg","contextImg");
//            blog.setId(id);
//            blogMapper.insertBlog(blog);
//        }
//    }
//
//    @Test
//    public void update()
//    {
//        int id = 1;
//        // 指定查詢库的路由規則
//        //根据规则得到分库索引
//        int dbIndex = ZdalRuleParser.parserDbIndex(id);
//        String dbSelectorID = logicPhysicsIndexes.get(dbIndex);
//        System.out.println("dbSelectorID = " + dbSelectorID);
//        //根据规则得到分表索引
//        int tbIndex = ZdalRuleParser.parserTbIndex(id);
//        String tablePostfix = new DecimalFormat("_00").format(tbIndex);//如果tbIndex为3，tablePostfix为_03
//        //根据分表索引得到物理表名称
//        String physicTableName = tbName + tablePostfix;
//         System.out.println("physicTableName = " + physicTableName);//physicTableName = t_city_00、t_city_01、t_city_02等
//        //得到 数据库选择器标识路由条件---确定是存在哪一个数据库中
//        DBSelectorIDRouteCondition dbSelectorIDRouteCondition = new DBSelectorIDRouteCondition("t_blog", dbSelectorID, physicTableName);
//        //将分库分表添加到线程中
//        ThreadLocalMap.put(ThreadLocalString.ROUTE_CONDITION, dbSelectorIDRouteCondition);
//
//
//        Blog blog = new Blog("一、Java虚拟机的生命周期","java中JVM的原理",new Date(),2,"mysql",1,1,"文章实际内容","sumimg","contextImg");
//        blog = new Blog();
//        blog.setBlogType("JAVA类");
//        blog.setId(id);
//
//        service.update(blog);
//    }
//
//    @Test
//    public void delete()
//    {
//        int id = 4;
////        // 指定查詢库的路由規則
////        //根据规则得到分库索引
////        int dbIndex = ZdalRuleParser.parserDbIndex(id);
////        String dbSelectorID = logicPhysicsIndexes.get(dbIndex);
////        System.out.println("dbSelectorID = " + dbSelectorID);
////        //根据规则得到分表索引
////        int tbIndex = ZdalRuleParser.parserTbIndex(id);
////        String tablePostfix = new DecimalFormat("_00").format(tbIndex);//如果tbIndex为3，tablePostfix为_03
////        //根据分表索引得到物理表名称
////        String physicTableName = tbName + tablePostfix;
////        System.out.println("physicTableName = " + physicTableName);//physicTableName = t_city_00、t_city_01、t_city_02等
////        //得到 数据库选择器标识路由条件---确定是存在哪一个数据库中
////        DBSelectorIDRouteCondition dbSelectorIDRouteCondition = new DBSelectorIDRouteCondition("t_blog", dbSelectorID, physicTableName);
////        //将分库分表添加到线程中
////        ThreadLocalMap.put(ThreadLocalString.ROUTE_CONDITION, dbSelectorIDRouteCondition);
//
//        Blog blog = new Blog();
//        blog.setId(id);
//        service.delete(blog);
//    }
//
//    @Test
//    public void selectAll()
//    {
//        List<Blog> blogList = new ArrayList<Blog>();
//        for(int i=0;i<4;i++)
//        {
//            // 指定查詢库的路由規則
//            //根据规则得到分库索引
//            int dbIndex = ZdalRuleParser.parserDbIndex(i);
//            String dbSelectorID = logicPhysicsIndexes.get(dbIndex);
//            System.out.println("dbSelectorID = " + dbSelectorID);
//            //根据规则得到分表索引
//            int tbIndex = ZdalRuleParser.parserTbIndex(i);
//            String tablePostfix = new DecimalFormat("_00").format(tbIndex);//如果tbIndex为3，tablePostfix为_03
//            //根据分表索引得到物理表名称
//            String physicTableName = tbName + tablePostfix;
//            System.out.println("physicTableName = " + physicTableName);//physicTableName = t_city_00、t_city_01、t_city_02等
//            //得到 数据库选择器标识路由条件---确定是存在哪一个数据库中
//            DBSelectorIDRouteCondition dbSelectorIDRouteCondition = new DBSelectorIDRouteCondition("t_blog", dbSelectorID, physicTableName);
//            //将分库分表添加到线程中
//            ThreadLocalMap.put(ThreadLocalString.ROUTE_CONDITION, dbSelectorIDRouteCondition);
//
////            List<Blog> allBlog = service.findAllBlog(pageVO.getBegin(), pageVO.getEnd());
////            blogList.addAll(allBlog);
//        }
//        Collections.sort(blogList,new BlogComparator());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        for (Blog blog:blogList)
//        {
//            System.out.println("id = "+blog.getId()+"  '"+"时间："+sdf.format(blog.getCreateTime()));
//        }
//    }
//
//    @Test
//    public void findOne()
//    {
//        int id = 3;
//        Blog blog = service.findBlogById(id);
//        System.out.println(blog);
//    }
//}
