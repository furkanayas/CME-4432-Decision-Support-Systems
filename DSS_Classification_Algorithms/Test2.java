import java.awt.image.ColorConvertOp;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;

//import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.lazy.IBk;
import weka.classifiers.functions.SGD;
import weka.classifiers.functions.SGDText;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.J48;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.trees.RandomTree;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.functions.supportVector.*;
import weka.core.Instances;
import weka.core.converters.*;
import weka.filters.UnsupervisedFilter;

import java.text.*;

public class Test2 {

	final static int percentSplit = 66;
    static weka.classifiers.Classifier cl = null;

    static weka.classifiers.Classifier SMOcl = null;
    static weka.classifiers.Classifier NaiveBayescl = null;
    static weka.classifiers.Classifier RandomForestcl = null;
    static weka.classifiers.Classifier RandomTreecl = null;
    static weka.classifiers.Classifier MultiLayerPerceptroncl = null;
    static weka.classifiers.Classifier J48cl = null;
    static weka.classifiers.Classifier _1BKcl = null;
    static weka.classifiers.Classifier _3BKcl = null;
    static weka.classifiers.Classifier _5BKcl = null;

    public static double SMOclassifyTest(weka.core.Instances insts)
    {
        try
        {
            insts.setClassIndex(insts.numAttributes() - 1);

            SMOcl = new weka.classifiers.functions.SMO();

            weka.filters.Filter myNB = new weka.filters.unsupervised.attribute.NominalToBinary();
            myNB.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myNB);

            
           // weka.filters.Filter myNormalized = new weka.filters.unsupervised.instance.Normalize();
            Normalize myNormalized = new Normalize();// works
            myNormalized.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myNormalized);

            weka.filters.Filter myRandom = new weka.filters.unsupervised.instance.Randomize();
            myRandom.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myRandom);

            int trainSize = insts.numInstances() * percentSplit / 100;
            int testSize = insts.numInstances() - trainSize;
            weka.core.Instances train = new weka.core.Instances(insts, 0, trainSize);

            SMOcl.buildClassifier(train);


            int numCorrect = 0;
            for (int i = trainSize; i < insts.numInstances(); i++)
            {
                weka.core.Instance currentInst = insts.instance(i);
                double predictedClass = SMOcl.classifyInstance(currentInst);
                if (predictedClass == insts.instance(i).classValue())
                    numCorrect++;
            }
            return (double)numCorrect / (double)testSize * 100.0;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }

    public static double NaiveBayesclassifyTest(weka.core.Instances insts)
    {
        try
        {
            //weka.core.Instances insts = new weka.core.Instances(new java.io.FileReader("iris.arff"));

            insts.setClassIndex(insts.numAttributes() - 1);

            NaiveBayescl = new weka.classifiers.bayes.NaiveBayes();

            weka.filters.Filter myDisc = new weka.filters.unsupervised.attribute.Discretize();
            myDisc.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myDisc);


            weka.filters.Filter myRandom = new weka.filters.unsupervised.instance.Randomize();
            myRandom.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myRandom);

            int trainSize = insts.numInstances() * percentSplit / 100;
            int testSize = insts.numInstances() - trainSize;
            weka.core.Instances train = new weka.core.Instances(insts, 0, trainSize);

            NaiveBayescl.buildClassifier(train);


            int numCorrect = 0;
            for (int i = trainSize; i < insts.numInstances(); i++)
            {
                weka.core.Instance currentInst = insts.instance(i);
                double predictedClass = NaiveBayescl.classifyInstance(currentInst);
                if (predictedClass == insts.instance(i).classValue())
                    numCorrect++;
            }
            return (double)numCorrect / (double)testSize * 100.0;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }

    public static double RandomForestclassifyTest(weka.core.Instances insts)
    {
        try
        {
            //weka.core.Instances insts = new weka.core.Instances(new java.io.FileReader("iris.arff"));

            insts.setClassIndex(insts.numAttributes() - 1);

            RandomForestcl = new weka.classifiers.trees.RandomForest();

            weka.filters.Filter myRandom = new weka.filters.unsupervised.instance.Randomize();
            myRandom.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myRandom);

            int trainSize = insts.numInstances() * percentSplit / 100;
            int testSize = insts.numInstances() - trainSize;
            weka.core.Instances train = new weka.core.Instances(insts, 0, trainSize);

            RandomForestcl.buildClassifier(train);


            int numCorrect = 0;
            for (int i = trainSize; i < insts.numInstances(); i++)
            {
                weka.core.Instance currentInst = insts.instance(i);
                double predictedClass = RandomForestcl.classifyInstance(currentInst);
                if (predictedClass == insts.instance(i).classValue())
                    numCorrect++;
            }
            return (double)numCorrect / (double)testSize * 100.0;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }

    public static double RandomTreeclassifyTest(weka.core.Instances insts)
    {
        try
        {
            //weka.core.Instances insts = new weka.core.Instances(new java.io.FileReader("iris.arff"));

            insts.setClassIndex(insts.numAttributes() - 1);

            RandomTreecl = new weka.classifiers.trees.RandomTree();


            weka.filters.Filter myRandom = new weka.filters.unsupervised.instance.Randomize();
            myRandom.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myRandom);

            int trainSize = insts.numInstances() * percentSplit / 100;
            int testSize = insts.numInstances() - trainSize;
            weka.core.Instances train = new weka.core.Instances(insts, 0, trainSize);

            RandomTreecl.buildClassifier(train);


            int numCorrect = 0;
            for (int i = trainSize; i < insts.numInstances(); i++)
            {
                weka.core.Instance currentInst = insts.instance(i);
                double predictedClass = RandomTreecl.classifyInstance(currentInst);
                if (predictedClass == insts.instance(i).classValue())
                    numCorrect++;
            }
            return (double)numCorrect / (double)testSize * 100.0;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }

    public static double J48classifyTest(weka.core.Instances insts)
    {
        try
        {
            //weka.core.Instances insts = new weka.core.Instances(new java.io.FileReader("iris.arff"));

            insts.setClassIndex(insts.numAttributes() - 1);

            J48cl = new weka.classifiers.trees.J48();

            weka.filters.Filter myRandom = new weka.filters.unsupervised.instance.Randomize();
            myRandom.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myRandom);

            int trainSize = insts.numInstances() * percentSplit / 100;
            int testSize = insts.numInstances() - trainSize;
            weka.core.Instances train = new weka.core.Instances(insts, 0, trainSize);

            J48cl.buildClassifier(train);


            int numCorrect = 0;
            for (int i = trainSize; i < insts.numInstances(); i++)
            {
                weka.core.Instance currentInst = insts.instance(i);
                double predictedClass = J48cl.classifyInstance(currentInst);
                if (predictedClass == insts.instance(i).classValue())
                    numCorrect++;
            }
            return (double)numCorrect / (double)testSize * 100.0;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }

    public static double MultiLayerPerceptronclassifyTest(weka.core.Instances insts)
    {
        try
        {
            //weka.core.Instances insts = new weka.core.Instances(new java.io.FileReader("iris.arff"));

            insts.setClassIndex(insts.numAttributes() - 1);

            MultiLayerPerceptroncl = new weka.classifiers.trees.J48();

            weka.filters.Filter myNB = new weka.filters.unsupervised.attribute.NominalToBinary();
            myNB.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myNB);

            //weka.filters.Filter myNormalized = new weka.filters.unsupervised.instance.Normalize();
            Normalize myNormalized = new Normalize();// works
            myNormalized.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myNormalized);

            weka.filters.Filter myRandom = new weka.filters.unsupervised.instance.Randomize();
            myRandom.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myRandom);

            int trainSize = insts.numInstances() * percentSplit / 100;
            int testSize = insts.numInstances() - trainSize;
            weka.core.Instances train = new weka.core.Instances(insts, 0, trainSize);

            MultiLayerPerceptroncl.buildClassifier(train);


            int numCorrect = 0;
            for (int i = trainSize; i < insts.numInstances(); i++)
            {
                weka.core.Instance currentInst = insts.instance(i);
                double predictedClass = MultiLayerPerceptroncl.classifyInstance(currentInst);
                if (predictedClass == insts.instance(i).classValue())
                    numCorrect++;
            }
            return (double)numCorrect / (double)testSize * 100.0;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }
    
    public static double _1BKclassifyTest(weka.core.Instances insts)
    {
        try
        {
            //weka.core.Instances insts = new weka.core.Instances(new java.io.FileReader("iris.arff"));

            insts.setClassIndex(insts.numAttributes() - 1);

            _1BKcl = new weka.classifiers.lazy.IBk(1);

            weka.filters.Filter myNB = new weka.filters.unsupervised.attribute.NominalToBinary();
            myNB.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myNB);

       //     weka.filters.Filter myNormalized = new weka.filters.unsupervised.instance.Normalize();
            Normalize myNormalized = new Normalize();// works
            myNormalized.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myNormalized);

            weka.filters.Filter myRandom = new weka.filters.unsupervised.instance.Randomize();
            myRandom.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myRandom);

            int trainSize = insts.numInstances() * percentSplit / 100;
            int testSize = insts.numInstances() - trainSize;
            weka.core.Instances train = new weka.core.Instances(insts, 0, trainSize);

            _1BKcl.buildClassifier(train);


            int numCorrect = 0;
            for (int i = trainSize; i < insts.numInstances(); i++)
            {
                weka.core.Instance currentInst = insts.instance(i);
                double predictedClass = _1BKcl.classifyInstance(currentInst);
                if (predictedClass == insts.instance(i).classValue())
                    numCorrect++;
            }
            return (double)numCorrect / (double)testSize * 100.0;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }

    public static double _3BKclassifyTest(weka.core.Instances insts)
    {
        try
        {
            //weka.core.Instances insts = new weka.core.Instances(new java.io.FileReader("iris.arff"));

            insts.setClassIndex(insts.numAttributes() - 1);

            _3BKcl = new weka.classifiers.lazy.IBk(3);

            weka.filters.Filter myNB = new weka.filters.unsupervised.attribute.NominalToBinary();
            myNB.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myNB);

         //   weka.filters.Filter myNormalized = new weka.filters.unsupervised.instance.Normalize();
            Normalize myNormalized = new Normalize();// works
            myNormalized.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myNormalized);

            weka.filters.Filter myRandom = new weka.filters.unsupervised.instance.Randomize();
            myRandom.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myRandom);

            int trainSize = insts.numInstances() * percentSplit / 100;
            int testSize = insts.numInstances() - trainSize;
            weka.core.Instances train = new weka.core.Instances(insts, 0, trainSize);

            _3BKcl.buildClassifier(train);


            int numCorrect = 0;
            for (int i = trainSize; i < insts.numInstances(); i++)
            {
                weka.core.Instance currentInst = insts.instance(i);
                double predictedClass = _3BKcl.classifyInstance(currentInst);
                if (predictedClass == insts.instance(i).classValue())
                    numCorrect++;
            }
            return (double)numCorrect / (double)testSize * 100.0;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }

    public static double _5BKclassifyTest(weka.core.Instances insts)
    {
        try
        {
            //weka.core.Instances insts = new weka.core.Instances(new java.io.FileReader("iris.arff"));

            insts.setClassIndex(insts.numAttributes() - 1);

            _5BKcl = new weka.classifiers.lazy.IBk(5);

            weka.filters.Filter myNB = new weka.filters.unsupervised.attribute.NominalToBinary();
            myNB.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myNB);

            //weka.filters.Filter myNormalized = new weka.filters.unsupervised.instance.Normalize();
            Normalize myNormalized = new Normalize();// works
            myNormalized.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myNormalized);

            weka.filters.Filter myRandom = new weka.filters.unsupervised.instance.Randomize();
            myRandom.setInputFormat(insts);
            insts = weka.filters.Filter.useFilter(insts, myRandom);

            int trainSize = insts.numInstances() * percentSplit / 100;
            int testSize = insts.numInstances() - trainSize;
            weka.core.Instances train = new weka.core.Instances(insts, 0, trainSize);

            _5BKcl.buildClassifier(train);


            int numCorrect = 0;
            for (int i = trainSize; i < insts.numInstances(); i++)
            {
                weka.core.Instance currentInst = insts.instance(i);
                double predictedClass = _5BKcl.classifyInstance(currentInst);
                if (predictedClass == insts.instance(i).classValue())
                    numCorrect++;
            }
            return (double)numCorrect / (double)testSize * 100.0;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }
   
  
    
    public static void main(String[] args,String yol) throws Exception
    {
    	System.out.println("Hello C#, from Java!");
       // Console.WriteLine("Hello Java, from C#!");

    	//OpenFileSwing o = new OpenFileSwing();
    	
    //	OpenFile op = new OpenFile();
    	
    //	String yol = op.fileChooser.getSelectedFile().toString();
    	
    	
    	
    	//"data/iris.arff"
    	
        weka.core.Instances insts = new weka.core.Instances(new java.io.FileReader(yol));

        weka.core.Instances insts2 = new weka.core.Instances(new java.io.FileReader(yol));

        double max_value = 0;

        double J48_rate = max_value = J48classifyTest(insts);
        insts = insts2;

        cl = J48cl;

        double RandomForest_rate = RandomForestclassifyTest(insts);
        insts = insts2;

        if (RandomForest_rate > max_value)
        {
            cl = RandomForestcl;
            max_value = RandomForest_rate;
        }


        double RandomTree_rate = RandomTreeclassifyTest(insts);
        insts = insts2;

        if (RandomTree_rate > max_value)
        {
            cl = RandomTreecl;
            max_value = RandomTree_rate;
        }

        double MultiLayerPerceptron_rate = MultiLayerPerceptronclassifyTest(insts);
        insts = insts2;

        if (MultiLayerPerceptron_rate > max_value)
        {
            cl = MultiLayerPerceptroncl;
            max_value = MultiLayerPerceptron_rate;
        }

        double SMO_rate = SMOclassifyTest(insts);
        insts = insts2;

        if (SMO_rate > max_value)
        {
            cl = SMOcl;
            max_value = SMO_rate;
        }

        double NaiveBayes_rate = NaiveBayesclassifyTest(insts);
        insts = insts2;

        if (NaiveBayes_rate > max_value)
        {
            cl = NaiveBayescl;
            max_value = NaiveBayes_rate;
        }

        double _1BK_rate = _1BKclassifyTest(insts);
        insts = insts2;

        if (_1BK_rate > max_value)
        {
            cl = _1BKcl;
            max_value = _1BK_rate;
        }

        double _3BK_rate = _3BKclassifyTest(insts);
        insts = insts2;

        if (_3BK_rate > max_value)
        {
            cl = _3BKcl;
            max_value = _3BK_rate;
        }

        double _5BK_rate = _5BKclassifyTest(insts);
        insts = insts2;

        if (_5BK_rate > max_value)
        {
            cl = _5BKcl;
            max_value = _5BK_rate;
        }

        System.out.println(max_value);
        System.out.println(cl.toString());
        
   //     Console.WriteLine(max_value);
     //   Console.WriteLine(cl.toString());


        //kullanıcıdan bilgileri al, dosya oluştur

        weka.core.Instances instsX = new weka.core.Instances(new java.io.FileReader(yol));

        instsX.setClassIndex(instsX.numAttributes() - 1);

        double index = cl.classifyInstance(instsX.instance(0));

        System.out.println(index);
      //  System.out.println(insts.vattribute(instsX.numAttributes() - 1).value(Convert.ToInt32(index)));

        System.out.println(insts.attribute(instsX.numAttributes() - 1).value((int)(index)));
        //Console.ReadLine();
    }

    
}
