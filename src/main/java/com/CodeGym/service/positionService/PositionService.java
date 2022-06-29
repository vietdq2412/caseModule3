package com.CodeGym.service.positionService;

import com.CodeGym.model.Position;
import com.CodeGym.service.DBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class PositionService implements IPositionService {
    private DBHandler<Position> positionDBHandler = DBHandler.getInstance();
    private final String POSITION_TABLE = "`position`";
    private static PositionService instance;

    private PositionService() {

    }

    public static PositionService getInstance() {
        if (instance == null) {
            instance = new PositionService();
            return instance;
        }
        return instance;
    }

    @Override
    public Boolean create(Position position) {
        return positionDBHandler.insertData(POSITION_TABLE, position, position.getColumns());
    }

    @Override
    public HashMap<Integer, Position> find(String condition) {
        ResultSet rs = positionDBHandler.findAllByCondition(POSITION_TABLE, condition);
        HashMap<Integer, Position> positionHashMap = new HashMap<>();
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");
                String description = rs.getString("description");
                int maxSize = rs.getInt("max_position");
                int currentUnit = rs.getInt("current_unit");
                Position position = new Position(id, name, description, maxSize, currentUnit);
                positionHashMap.put(id, position);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return positionHashMap;
    }

    @Override
    public Position findById(int id) {
        String condition = "Where id = " + id;
        return find(condition).get(id);
    }

    @Override
    public Position update(int id) {
        return null;
    }

    @Override
    public Position delete(int id) {
        return null;
    }
}
