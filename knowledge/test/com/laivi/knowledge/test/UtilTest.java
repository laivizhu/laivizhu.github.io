package com.laivi.knowledge.test;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_objdetect;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;

import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.JsonUtil;
import com.laivi.knowledge.book.model.po.Chapter;
import com.laivi.knowledge.book.util.BookChapterUtil;
import com.laivi.knowledge.common.model.type.FavoriteType;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_objdetect.*;


/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
 */
public class UtilTest {
    //static{ System.loadLibrary("opencv_java244"); }


	@Test
	public void testDataUtil() throws ErrorException{
		String str="字符串不合法abc不合法";
		System.out.println(DataUtil.getDefaultChar(str,9));
	}
    @Test
    public void testEnumJson()throws ErrorException{
        FavoriteType type=FavoriteType.ARTICLE;
        System.out.println(JsonUtil.parseArray(type));
    }
    @Test
    public void testJsonList()throws ErrorException{
    	JsonList jsonList=new JsonList();
    	jsonList.add("abc");
    	jsonList.add("abe");
    	jsonList.add("abf");
    	System.out.print(jsonList.toString());
    }
    
    @Test
    public void testBook()throws ErrorException{
    	File file=new File("D:\\Media\\Book\\book\\采花录.txt");
    	List<Chapter> chapterList=BookChapterUtil.getChapters(file);
    	System.out.println("size:"+chapterList.size());
    }
    @Test
    public void testIKAnalyzer() throws ErrorException, IOException {
        String text="新来的应届毕业生问我：我是个很”自我”的人，周围的同事说我没礼貌、不懂人情世故，我错了吗？";
        //创建分词对象
        IKAnalyzer anal=new IKAnalyzer(true);
        StringReader reader=new StringReader(text);
        //分词
        TokenStream ts=anal.tokenStream("", reader);
        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);
        //遍历分词数据
        while(ts.incrementToken()){
            System.out.print(term.toString()+"|");
        }
        reader.close();
        System.out.println();
    }

    @Test
    public void testLucene() throws IOException {
        String text="新来的应届毕业生问我：我是个很”自我”的人，周围的同事说我没礼貌、不懂人情世故，我错了吗？";
        StringReader sr=new StringReader(text);
        IKSegmenter ik=new IKSegmenter(sr, true);
        Lexeme lex=null;
        while((lex=ik.next())!=null){
            System.out.print(lex.getLexemeText()+"|");
        }
    }

    @Test
    public void testJavaCV(){
        String filename="D:\\temp\\IMG_1091.jpg";
        opencv_core.IplImage image=cvLoadImage(filename);
        if(image!=null){
            cvSmooth(image,image,CV_GAUSSIAN,3);
            cvNamedWindow("test",CV_WINDOW_NORMAL );
            cvShowImage("test",image);
            cvWaitKey(0);
            //cvSaveImage("D:\\temp\\IMG_1091.bmp",image);
            cvReleaseImage(image);
        }

       /* CvMat mat=cvCreateMat(3,4,CV_8UC1 );
        cvZero(mat);
        System.out.println(mat);*/
    }

    @Test
    public void testDetectFace(){
        String filename="D:\\temp\\lena.jpg";
        opencv_core.IplImage img=cvLoadImage(filename);
        String  cascade_name="C:\\opencv\\data\\haarcascades\\haarcascade_eye.xml";
        CvMemStorage storage=new CvMemStorage() ;
        opencv_objdetect.CvHaarClassifierCascade cascade;
        CvScalar color=new CvScalar();

        double scale = 1.3;
        IplImage gray = cvCreateImage( cvSize(img.width(),img.height()), 8, 1 );
        IplImage small_img = cvCreateImage( cvSize((int)(img.width()/scale),(int)(img.height()/scale)),8, 1 );
        int i;

        cvCvtColor( img, gray, CV_BGR2GRAY );
        cvResize( gray, small_img, CV_INTER_LINEAR );
        cvEqualizeHist( small_img, small_img );
        cvClearMemStorage(storage);
        cascade = new opencv_objdetect.CvHaarClassifierCascade(cvLoad(cascade_name));
        if( cascade!=null ){
            double t = (double)cvGetTickCount();
            CvSeq faces = cvHaarDetectObjects(small_img,cascade,storage,1.1,2,0);
            t = (double)cvGetTickCount() - t;
            System.out.println("detection time ="+t/((double)cvGetTickFrequency()*1000));
            System.out.println("detection time ="+faces.total());
            for( i = 0; i < (faces!=null ? faces.total() : 0); i++ ){
                CvRect r = (CvRect)cvGetSeqElem( faces, i );
                CvPoint center=new CvPoint((int)((r.x() + r.width()*0.5)*scale),(int)((r.y() + r.height()*0.5)*scale));
                int radius;
                radius = (int)((r.width() + r.height())*0.25*scale);
                cvCircle( img, center, radius, color, 3, 8, 0 );
            }
        }
        cvShowImage("result",img );
        cvReleaseImage(gray );
        cvReleaseImage(small_img);
        cvWaitKey(0);

    }

    @Test
    public void testJavaCVDetect(){
        int SCALE = 2;
        String CASCADE_FILE ="C:\\opencv\\data\\haarcascades\\haarcascade_frontalface_alt2.xml";
        String OUT_FILE = "D:\\temp\\markedFaces.jpg";
        IplImage origImg = cvLoadImage("D:/temp/123.jpg", 1);
        //IplImage origImg = cvLoadImage(args[0]);
        // convert to grayscale
        IplImage grayImg = IplImage.create(origImg.width(),origImg.height(), IPL_DEPTH_8U, 1);
        cvCvtColor(origImg, grayImg, CV_BGR2GRAY);
        // scale the grayscale (to speed up face detection)
        IplImage smallImg = IplImage.create(grayImg.width()/SCALE,grayImg.height()/SCALE, IPL_DEPTH_8U, 1);
        cvResize(grayImg, smallImg, CV_INTER_LINEAR);
        // equalize the small grayscale
        IplImage equImg = IplImage.create(smallImg.width(),smallImg.height(), IPL_DEPTH_8U, 1);
        cvEqualizeHist(smallImg, equImg);
        // create temp storage, used during object detection
        CvMemStorage storage = CvMemStorage.create();
        // instantiate a classifier cascade for face detection
        opencv_objdetect.CvHaarClassifierCascade cascade =new opencv_objdetect.CvHaarClassifierCascade(cvLoad(CASCADE_FILE));
        System.out.println("Detecting faces...");
        CvSeq faces = cvHaarDetectObjects(equImg, cascade, storage,1.1, 2, CV_HAAR_DO_CANNY_PRUNING,cvSize(20,20),cvSize(100,100));
        cvClearMemStorage(storage);
        // draw thick yellow rectangles around all the faces
        int total = faces.total();
        System.out.println("Found " + total + " face(s)");
        for (int i = 0; i < total; i++) {
            CvRect r = new CvRect(cvGetSeqElem(faces, i));
            cvRectangle(origImg, cvPoint( r.x()*SCALE, r.y()*SCALE ),cvPoint( (r.x() + r.width())*SCALE,(r.y() + r.height())*SCALE ),CvScalar.RED, 6, CV_AA, 0);
            String strRect = String.format("CvRect(%d,%d,%d,%d)", r.x(), r.y(), r.width(), r.height());
            System.out.println(strRect);
        }
        if (total > 0) {
            System.out.println("Saving marked-faces version of " + " in " + OUT_FILE);
            cvSaveImage(OUT_FILE, origImg);
            //cvNamedWindow( "result", 1 );
            //cvShowImage( "result", origImg );
            //cvWaitKey(0);
        }
    }

}
