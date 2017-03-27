package NLPTools;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ${Ashsih} on ${14-Mar-16}.
 */
public class SentenceDetect {

    public static void SentenceDetect() throws InvalidFormatException,
            IOException {
        String paragraph = "Timeline. This section is easily overlooked, yet its arguably more important than the previous section. With the timeline section you show that you understand the problem, that you have thought hard about a solution, and that you have also broken the solution down into manageable bits. If your timeline is reasonable and its deadlines achievable, you show that you have an actual path in mind that would take you from idea to delivery. With this section you set expectations, so do not make promises you cannot keep. A humble, realistic and detailed timeline is much better than a timeline that promises to move mountains. Google has selected the very best open source organizations in the world to take part in Google Summer of Code, and the mentors in these organizations are often the top professionals in their respective fields. Mentors can easily spot unrealistic timelines. ";

        // always start with a model, a model is learned from training data
        InputStream is = new FileInputStream("NLPTools\\en-sent.bin");
        SentenceModel model = new SentenceModel(is);
        SentenceDetectorME sdetector = new SentenceDetectorME(model);

        String sentences[] = sdetector.sentDetect(paragraph);

        System.out.println(sentences[0]);
        System.out.println(sentences[1]);
        System.out.println(sentences[2]);
        System.out.println(sentences[3]);
        System.out.println(sentences[4]);
        System.out.println(sentences[5]);
        System.out.println(sentences[6]);
        System.out.println(sentences[7]);
        System.out.println(sentences[8]);
        System.out.println(sentences[9]);
        is.close();
    }
}
