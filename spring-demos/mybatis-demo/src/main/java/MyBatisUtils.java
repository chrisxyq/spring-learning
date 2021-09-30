import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 写一个工具类，以获取sqlsession
 */
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 第一步：通过读取mybatis配置文件，获取sqlSessionFactory：红框的声明是为了提升作用域。
     * sqlSessionFactory在静态代码块中被初始化。
     * 获取sqlSessionFactory对象的三句代码是死的，因此写到工具类里面
     */
    static {
        try{
            String resource = "mybatis-config.xml";
            InputStream inputStream =
                    Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第二步：从sqlSessionFactory.opensession()获取sqlSession对象
     * 这一部分写到静态方法里面
     * @return
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) {
        System.out.println(getSqlSession());
        //System.out.println(sqlSessionFactory);
        //System.out.println("sqlSessionFactory:"+ MyBatisUtils.sqlSessionFactory);
    }
}
