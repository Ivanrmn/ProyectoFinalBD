package org.mvpigs.proyectoFinalBD.dao;

import org.mvpigs.proyectoFinalBD.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import java.sql.SQLException;
import java.util.List;

@Component
    public class ProductDaoJdbcImpl implements ProductDao {

        private final JdbcTemplate jdbcTemplate;

        @Autowired
        public ProductDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        @Override
        @RequestMapping("/insert")
        public void insert(ProductDto productDto) {
            String sql = "INSERT INTO FRUITS(ID_FRUIT, NAME, DESCRIPTION, PRICE_PER_KG, DATE_CREATED values(?,?,?,?,?)";
            jdbcTemplate.update(sql, productDto.getId(), productDto.getName(), productDto.getDescription(), productDto.getPrice());
        }

        @Override
        @RequestMapping("/update")
        public void update(ProductDto productDto) {
            jdbcTemplate.update(
                    "UPDATE FRUITS SET ID_FRUIT=?, NAME=?, DESCRIPTION=?, PRICE_PER_KG=?, DATE_CREATED=? ");
        }

        @Override
        @RequestMapping("/delete")
        public void delete(ProductDto productDto) {
            jdbcTemplate.update("DELETE FROM FRUITS WHERE ID_FRUIT = ?", new Object[]{productDto.getId()});
        }

        @Override
        public String getProduct(Long id) {
            String sql = "SELECT NAME FROM FRUITS WHERE ID_FRUIT = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
        }

        @Override
        public List<ProductDto> list() {
            String sql = "SELECT * FROM FRUITS ORDER BY NAME";
            List<ProductDto> fruitList = jdbcTemplate.query(sql, (resultSet, i) -> {
                // crear y asignar un nuevo FruitDto
                try {
                    ProductDto emp = new ProductDto();
                    emp.setId(resultSet.getLong("ID_FRUIT"));
                    emp.setName(resultSet.getString("NAME"));
                    emp.setDescription(resultSet.getString("DESCRIPTION"));
                    emp.setPrice(resultSet.getDouble("PRICE_PER_KG"));

                    return emp;
                } catch (SQLException e) {
                    throw new SQLException("Error interno: " + e.getMessage(), e.getCause());
                }
            });
            return fruitList;
        }
    }
}
