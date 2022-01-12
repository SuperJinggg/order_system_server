package website.abyss.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.ordersystem.entities.Customer;
import website.abyss.ordersystem.entities.Reserve;
import website.abyss.ordersystem.entities.Table;
import website.abyss.ordersystem.mapper.ReserveMapper;

import java.util.List;

@Service
@Transactional
public class ReserveService {

    private ReserveMapper reserveMapper;

    @Autowired
    public ReserveService(ReserveMapper reserveMapper) {
        this.reserveMapper = reserveMapper;
    }

    public boolean verifyReserve(Reserve reserve) {
        if(reserveMapper.verifyReserve(reserve)==null){
            return true;
        }
        return false;
    }

    public void addReserve(Reserve reserve) {
        reserveMapper.addReserve(reserve);
    }

    public Reserve getByReserveId(Integer reserveId) {
        return reserveMapper.getByReserveId(reserveId);
    }

    public void deleteReserve(Reserve reserve) {
        reserveMapper.deleteReserve(reserve);
    }

    public void changeReserve(Reserve reserve) {
        reserveMapper.changeReserve(reserve);
    }

    public List<Reserve> findReserveByTable(Table table) {
        return reserveMapper.findReserveByTable(table.getTableId());
    }
}
