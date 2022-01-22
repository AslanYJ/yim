package com.yjlan.im.business;

import com.yjlan.im.business.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = BusinessApplication.class)
@RunWith(SpringRunner.class)
public class TestMysql {

    @Resource
    private TestMapper testMapper;

    @Test
    public void test() {
        com.yjlan.im.business.entity.Test test = new com.yjlan.im.business.entity.Test();
        test.setAccount("test2");
        testMapper.insert(test);
    }


}
