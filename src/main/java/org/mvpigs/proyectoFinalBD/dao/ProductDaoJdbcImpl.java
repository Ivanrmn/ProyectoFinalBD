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
            String sql = "INSERT INTO PRODUCTS(ID_PRODUCT, NAME, DESCRIPTION, PRICE, values(?,?,?,?)";
            jdbcTemplate.update(sql, productDto.getId(), productDto.getName(), productDto.getDescription(), productDto.getPrice());
        }

        @Override
        @RequestMapping("/update")
        public void update(ProductDto productDto) {
            jdbcTemplate.update(
                    "UPDATE PRODUCTS SET ID_PRODUCT=?, NAME=?, DESCRIPTION=?, PRICE=?");
        }

        @Override
        @RequestMapping("/delete")
        public void delete(ProductDto productDto) {
            jdbcTemplate.update("DELETE FROM PRODUCTS WHERE ID_PRODUCT = ?", new Object[]{productDto.getId()});
        }

        @Override
        public String getProduct(Long id) {
            String sql = "SELECT NAME FROM PRODUCTS WHERE ID_PRODUCTS = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
        }

        @Override
        public List<ProductDto> list() {
            String sql = "SELECT * FROM PRODUCTS ORDER BY NAME";
            List<ProductDto> productList = jdbcTemplate.query(sql, (resultSet, i) -> {
                try {
                    ProductDto emp = new ProductDto();
                    emp.setId(resultSet.getLong("ID_PRODUCT"));
                    emp.setName(resultSet.getString("NAME"));
                    emp.setDescription(resultSet.getString("DESCRIPTION"));
                    emp.setPrice(resultSet.getDouble("PRICE"));

                    return emp;
                } catch (SQLException e) {
                    throw new SQLException("Error interno: " + e.getMessage(), e.getCause());
                }
            });
            return productList;
        }
    }
