package website.abyss.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.ordersystem.entities.Table;
import website.abyss.ordersystem.mapper.TableMapper;

import java.util.List;

@Service
@Transactional
public class TableService {

    private TableMapper tableMapper;

    @Autowired
    public TableService(TableMapper tableMapper) {
        this.tableMapper = tableMapper;
    }

    public Table getByTableId(String tableId) {
        return tableMapper.getByTableId(tableId);
    }

    public void addTable(Table table) {
        tableMapper.addTable(table);
    }

    public void deleteTable(Table table) {
        tableMapper.deleteTable(table);
    }

    public void changeTable(Table table) {
        tableMapper.changeTable(table);
    }

    public List<Table> findTableList() {
        return tableMapper.findTableList();
    }

    public List<Table> findFreeTableList() {
        return tableMapper.findFreeTableList();
    }
}
