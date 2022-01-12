package website.abyss.ordersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.ordersystem.entities.Reserve;

import java.util.List;

@Mapper
public interface ReserveMapper {

    Reserve verifyReserve(Reserve reserve);

    void addReserve(Reserve reserve);

    Reserve getByReserveId(Integer reserveId);

    void deleteReserve(Reserve reserve);

    void changeReserve(Reserve reserve);

    List<Reserve> findReserveByTable(String tableId);
}