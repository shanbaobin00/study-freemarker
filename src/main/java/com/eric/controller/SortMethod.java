package com.eric.controller;

import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.apache.commons.collections.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author shanbb
 * @description 自定义排序方法
 *  编写freemarker的自定义方法需要实现TemplateMethodModelEx接口并重写exec方法
 * @date 2019-08-24
 */
public class SortMethod implements TemplateMethodModelEx {
    @Override
    public Object exec(List args) throws TemplateModelException {

        //获取第一个参数,这里要先转化为freemarker数据的类型，然后再转成java的类型，直接转会报错
        SimpleSequence arg0 = (SimpleSequence) args.get(0);
        List<BigDecimal> list =  arg0.toList();

        Collections.sort(list, new Comparator<BigDecimal>() {
            @Override
            public int compare(BigDecimal o1, BigDecimal o2) {
                return o1.intValue() - o2.intValue();//升序
            }
        });

        return list;
    }
}
