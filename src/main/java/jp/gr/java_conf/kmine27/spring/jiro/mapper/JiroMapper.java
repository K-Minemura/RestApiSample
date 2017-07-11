package jp.gr.java_conf.kmine27.spring.jiro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import jp.gr.java_conf.kmine27.spring.jiro.domain.Jiro;

@Mapper
public interface JiroMapper {

    static String SELECT_ALL = "" + //
            "SELECT \n" + //
            "    JR.ID        AS ID         \n" + //
            "   ,JR.NAME      AS NAME       \n" +
            "   ,JR.ADDRESS   AS ADDRESS    \n" +
            "   ,JR.LATITUDE  AS LATITUDE   \n" +
            "   ,JR.LONGITUDE AS LONGITUDE  \n" +
            "   ,MN.ID        AS MENU_ID    \n" + //
            "   ,MN.NAME      AS MENU_NAME  \n" + //
            "   ,MN.PRICE     AS MENU_PRICE \n" + //
            "FROM \n" + //
            "    JIRO JR \n" + //
            "LEFT OUTER JOIN \n" + //
            "    MENU MN \n" + //
            "ON \n" + //
            "    MN.JIRO_ID = JR.ID \n" + //
            "ORDER BY \n" + //
            "    JR.ID \n" + //
            "   ,MN.ID \n" + //
            "";

    @Select(SELECT_ALL)
    @ResultMap("jiroResultMap")
    List<Jiro> findAll();
    
}
