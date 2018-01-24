package bwe.com.bawei.jdcom.classify.view;

import bwe.com.bawei.jdcom.classify.classifybean.ClassifyBean2;
import bwe.com.bawei.jdcom.classify.classifybean.Classify_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/27.
 */

public interface Classify_view {
   void getClassify(Classify_Bean classify_bean);
   void getClassify2(ClassifyBean2 classifyBean2);
   String cid();
}
