package guilherme_silva_camara;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Stack;

public class HtmlAnalyzer {

        public static void main(String[] args) throws Exception {

                if (args.length < 1) {
                        System.exit(1);
                }

                String url = args[0];
                String html = getHtml(url);

                if (checkMalformed(html)) {
                        System.out.println("malformed HTML");
                        System.exit(1);
                }

                String finalText = findDeepestText(html);
                System.out.println(finalText);
        }

        public static String getHtml(String urlString) throws Exception {

                URL url = new URL(urlString);
                URLConnection conn;
                BufferedReader in;

                try {
                        conn = url.openConnection();
                        in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                } catch (IOException e) {
                        System.out.println("URL connection error");
                        System.exit(1);
                        throw e;
                }

                StringBuilder sb = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                        sb.append(inputLine);
                }

                in.close();

                return sb.toString();
        }

        public static String findDeepestText(String html) {

                int level = 0;
                int deepestLevel = 0;
                int tagStart;
                int tagEnd;
                int textStart = 0;
                int textEnd = 0;
                String finalText = "";

                for (int i = 0; i < html.length(); i++) {

                        if (html.charAt(i) == '<') {

                                tagStart = i;

                                for (int j = i; j < html.length(); j++) {

                                        if (html.charAt(j) == '>') {

                                                if (html.charAt(tagStart + 1) == '/') {
                                                        level--;
                                                } else {
                                                        level++;
                                                }

                                                tagEnd = j;
                                                i = tagEnd;
                                                break;
                                        }
                                }
                        } else {
                                for (int j = i; j < html.length(); j++) {

                                        textStart = i;

                                        if (html.charAt(j) == '<') {

                                                textEnd = j - 1;

                                                if (level > deepestLevel
                                                                && !html.substring(textStart, textEnd).isBlank()) {

                                                        deepestLevel = level;
                                                        finalText = html.substring(textStart, textEnd);
                                                }

                                                i = j - 1;
                                                break;
                                        }
                                }
                        }

                }
                return finalText.trim();
        }

        public static boolean checkMalformed(String html) {

                Stack<String> tags = new Stack<String>();
                String openTag;
                String closeTag;

                for (int i = 0; i < html.length(); i++) {

                        if (html.charAt(i) == '<' && html.charAt(i + 1) != '/' && html.charAt(i + 1) != '!' && html.charAt(i + 1) != '-' && html.charAt(i + 1) != ' ') {
                                for (int j = i + 1; j < html.length(); j++) {

                                        if (html.charAt(j) == '>') {
                                                openTag = html.substring(i + 1, j);
                                                tags.push(openTag);
                                                i = j;
                                                break;
                                        }
                                }

                        } else if (html.charAt(i) == '<' && html.charAt(i + 1) == '/') {

                                for (int j = i + 2; j < html.length(); j++) {

                                        if (html.charAt(j) == '>') {
                                                closeTag = html.substring(i + 2, j);

                                                if (tags.contains(closeTag)) {
                                                        tags.remove(closeTag);
                                                        i = j;
                                                        break;
                                                }
                                        }
                                }
                        }
                }

                if (tags.isEmpty()) {
                        return false;
                }

                return true;
        }
}
