package OpenCV;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.objdetect.CascadeClassifier;

public class OpeningTry {
    public void run() {
        System.out.println("\nRunning first try");

        CascadeClassifier faceDetector = new CascadeClassifier(getClass().getResource("/lbpcascade_frontalface.xml").getPath());
    }

    public static void main(String[] args) {
        System.out.println("hello openCV");
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println(mat.dump());
        String fName = "sad.jpg";

    }
}
