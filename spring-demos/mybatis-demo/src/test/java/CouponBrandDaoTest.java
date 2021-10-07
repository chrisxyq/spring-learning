import dao.CouponBrandDao;
import entity.CouponBrandEntity;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CouponBrandDaoTest {
    @Test
    public void testGetEntityById(){
        final SqlSession sqlSession = MyBatisUtils.getSqlSession();
        final CouponBrandDao couponBrandDao = sqlSession.getMapper(CouponBrandDao.class);
        final CouponBrandEntity entityById = couponBrandDao.getEntityById(2685L);
        System.out.println(entityById);
        sqlSession.close();
    }
    @Test
    public void testAddCouponBrand(){
        final SqlSession sqlSession = MyBatisUtils.getSqlSession();
        final CouponBrandDao couponBrandDao = sqlSession.getMapper(CouponBrandDao.class);
        couponBrandDao.addCouponBrand(new CouponBrandEntity(2L,2L,2L));
        sqlSession.commit();
        sqlSession.close();
    }
}
