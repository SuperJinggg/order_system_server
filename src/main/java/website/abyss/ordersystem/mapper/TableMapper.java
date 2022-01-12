package website.abyss.ordersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.ordersystem.entities.Table;

import java.util.List;

@Mapper
public interface TableMapper {

    Table getByTableId(String tableId);

    void addTable(Table table);

    void deleteTable(Table table);

    void changeTable(Table table);

    List<Table> findTableList();

    List<Table> findFreeTableList();
}