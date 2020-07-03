package com.ecommerce.OnlineShopping.mapper;

import com.ecommerce.OnlineShopping.domain.ShoppingCart;
import com.ecommerce.OnlineShopping.domain.ShoppingCartExample;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ShoppingCartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Tue Jun 02 22:36:50 NPT 2020
     */
    long countByExample(ShoppingCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Tue Jun 02 22:36:50 NPT 2020
     */
    int deleteByExample(ShoppingCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Tue Jun 02 22:36:50 NPT 2020
     */
    int deleteByPrimaryKey(Long cartid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Tue Jun 02 22:36:50 NPT 2020
     */
    int insert(ShoppingCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Tue Jun 02 22:36:50 NPT 2020
     */
    int insertSelective(ShoppingCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Tue Jun 02 22:36:50 NPT 2020
     */
    List<ShoppingCart> selectByExample(ShoppingCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Tue Jun 02 22:36:50 NPT 2020
     */
    ShoppingCart selectByPrimaryKey(Long cartid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Tue Jun 02 22:36:50 NPT 2020
     */
    int updateByExampleSelective(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Tue Jun 02 22:36:50 NPT 2020
     */
    int updateByExample(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Tue Jun 02 22:36:50 NPT 2020
     */
    int updateByPrimaryKeySelective(ShoppingCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Tue Jun 02 22:36:50 NPT 2020
     */
    int updateByPrimaryKey(ShoppingCart record);

//    @Select("Select * from ShoppingCart sc LEFT JOIN Product p ON p.prodid = sc.prodid WHERE username = #{username} AND prodPrice = #{prodPrice}")
//    List<ShoppingCart> productInfo(@Param("username") String username, @Param("prodid") Long pid, @Param("prodPrice") BigDecimal prodPrice);

    ShoppingCart getShoppingCartByUsername(@Param("username") String username);

    @Select("SELECT SUM(prodPrice) AS TotalPrice FROM ShoppingCart WHERE username = #{username}")
    BigDecimal totalPrice(@Param("username") String username);

    @Select("DELETE FROM ShoppingCart WHERE prodId=#{prodId}")
    ShoppingCart removeFromCart(@Param("prodId") Long id);

    @Select("DELETE FROM ShoppingCart WHERE username=#{username}")
    ShoppingCart clearCart(@Param("username") String username);
}