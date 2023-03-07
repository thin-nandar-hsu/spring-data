package com.solt;

import com.solt.ds.Pair;
import com.solt.evaluator.AddEvaluator;
import com.solt.evaluator.MultiplyEvaluator;
import com.solt.render.FormalRender;
import com.solt.render.VerboseRender;
import com.solt.service.EvaluatorService;

public class Main {
    public static void main(String[] args) {
        EvaluatorService service = new EvaluatorService();
        service.takeAction(new MultiplyEvaluator(),new FormalRender(),new Pair(5,7));


//        service.takeAction(                                   * with Lambda Expression
//                           a -> a.getA() * a.getB(),
//                           a -> System.out.println("Ans:" + a),
//                           new Pair(5,7)
//        );
    }
}
