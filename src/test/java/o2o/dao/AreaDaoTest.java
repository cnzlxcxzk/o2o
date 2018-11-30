package o2o.dao;

import o2o.BaseTest;
import o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;
    @Test
    public void queryAreaTest() {
        List<Area> areas = areaDao.queryArea();
        assert areas.size() == 3;
        System.out.println(areas);

    }
}
