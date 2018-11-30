package o2o.dao;

import o2o.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 查询商店列表
     * @return
     */
    List<Area> queryArea();
}
