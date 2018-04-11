//import com.tao.model.User;
//import com.tao.service.UserService;
//import com.tao.util.ZdalRuleParser;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.text.DecimalFormat;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by Administrator on 2017/7/20.
// */
//public class UserServiceTest {
//    private UserService service;
//    private ZdalDataSource dataSource;
//    // 所有配置的物理数据源, dbIndex
//    private Map<Integer, String> logicPhysicsIndexes;
//
//    //库名
//    private String dbName = "blog";
//    //表名
//    private String tbName = "t_user";
//    @Before
//    public void init()
//    {
//        //加载spring容器，实例化bean
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        service = (UserService) context.getBean("userService");
//        dataSource = (ZdalDataSource) context.getBean("dataSource");
//
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
//
//    @Test
//    /**
//     * 插入数据库操作
//     */
//    public void insert(){
//
//        //设置插入10条id数据，id自增
//        for (int id=0;id<2;id++) {
//
//            // 指定查詢库的路由規則
//            //根据规则得到分库索引
//            int dbIndex = ZdalRuleParser.parserDbIndex(id);
//            String dbSelectorID = logicPhysicsIndexes.get(dbIndex);
//            System.out.println("dbSelectorID = " + dbSelectorID);
//            //根据规则得到分表索引
//            int tbIndex = ZdalRuleParser.parserTbIndex(id);
//            String tablePostfix = new DecimalFormat("_00").format(tbIndex);//如果tbIndex为3，tablePostfix为_03
//            //根据分表索引得到物理表名称
//            String physicTableName = tbName + tablePostfix;
//            System.out.println("physicTableName = " + physicTableName);//physicTableName = t_city_00、t_city_01、t_city_02等
//            //得到 数据库选择器标识路由条件---确定是存在哪一个数据库中
//            DBSelectorIDRouteCondition dbSelectorIDRouteCondition = new DBSelectorIDRouteCondition(
//                    "t_user", dbSelectorID, physicTableName);
//            //将分库分表添加到线程中
//            ThreadLocalMap.put(ThreadLocalString.ROUTE_CONDITION, dbSelectorIDRouteCondition);
//
//            System.out.println("配置完成，准备开始插入数据");
//            User user = new User("taohaowei","082737HaoWei","陶浩伟","男","taohwUp@163.com","17631335917","1497849146","taohaowei0");
//            service.insert(user);
//        }
//    }
//}
