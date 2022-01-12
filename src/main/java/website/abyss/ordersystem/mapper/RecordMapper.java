package website.abyss.ordersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.ordersystem.entities.Record;

import java.util.List;

@Mapper
public interface RecordMapper {

    Record getByRecord(Record record);

    void insertRecord(Record record);

    void updateRecord(Record record);

    void deleteRecord(Record record);
}