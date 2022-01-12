package website.abyss.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.ordersystem.mapper.RecordMapper;
import website.abyss.ordersystem.entities.Record;


@Service
@Transactional
public class RecordService {

    private RecordMapper recordMapper;

    @Autowired
    public RecordService(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }

    public Record getByRecord(Record record) {
        return recordMapper.getByRecord(record);
    }

    public void insertRecord(Record record) {
        recordMapper.insertRecord(record);
    }

    public void updateRecord(Record record) {
        recordMapper.updateRecord(record);
    }

    public void deleteRecord(Record record) {
        recordMapper.deleteRecord(record);
    }
}
