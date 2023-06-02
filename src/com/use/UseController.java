package com.use;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UseController {
    String INSERT_POST=" INSERT INTO post VALUES(?,?,?,?)";

    public boolean insertNewPost(Post post) throws Exception{
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        try {
            conn=DBUtil.getConnection();
            preparedStatement= conn.prepareStatement(INSERT_POST);
             preparedStatement.setInt(1,post.getUserId());
             preparedStatement.setInt(2,post.getId());
             preparedStatement.setString(3,post.getTitle());
             preparedStatement.setString(4,post.getBody());
             return (preparedStatement.executeUpdate() >0);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                preparedStatement.close();
                conn.close();
            }catch (Exception e){
                System.out.println(e.getMessage());

            }
        }
        return false;
    }
}
