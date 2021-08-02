package datastructure.abstract_test;

import common.constant.DigitalConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 图像数据处理.
 *
 * @author xindaqi
 * @date 2021-08-02 18:04
 */
public class ImageDataProcess extends AbstractClassTest {

    @Override
    List<Double> sparse(List<Double> inputs) {
        List<Double> sparseData = new ArrayList<>();
        for (Double data : Optional.ofNullable(inputs).orElse(new ArrayList<>())) {
            if(data < DigitalConstant.ZERO_D) {
                sparseData.add(DigitalConstant.ZERO_D);
            } else {
                sparseData.add(data);
            }
        }
        return sparseData;
    }

    @Override
    List<Double> expand(List<Double> inputs, Double rate) {
        List<Double> result = new ArrayList<>();
        for(Double data : Optional.ofNullable(inputs).orElse(new ArrayList<>())) {
            result.add(data * rate);
        }
        return result;
    }
}
