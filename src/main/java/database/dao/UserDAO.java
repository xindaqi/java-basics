package database.dao;

import database.dto.UserOutputDTO;

import java.util.List;

/**
 * 我是描述信息.
 *
 * @author xindaqi
 * @date 2021-05-14 16:08
 */
public interface UserDAO {

    /**
     * 分页查询用户信息
     * @return 用户列表
     */
    List<UserOutputDTO> queryUserByPage();
}
