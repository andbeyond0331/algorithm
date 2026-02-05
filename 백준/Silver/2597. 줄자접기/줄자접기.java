import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double a = Double.parseDouble(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    double red1 = Double.parseDouble(st.nextToken());
    double red2 = Double.parseDouble(st.nextToken());
    st = new StringTokenizer(br.readLine());
    double blue1 = Double.parseDouble(st.nextToken());
    double blue2 = Double.parseDouble(st.nextToken());
    st = new StringTokenizer(br.readLine());
    double yellow1 = Double.parseDouble(st.nextToken());
    double yellow2 = Double.parseDouble(st.nextToken());
    double redMiddle = (red1 + red2)/2;
    double start = 0;
    double end = a;
    if(end-redMiddle < redMiddle) {
      end = redMiddle;
      if(blue1>redMiddle) {
        blue1 = redMiddle-(blue1-redMiddle);
      }
      if(blue2>redMiddle) {
        blue2 = redMiddle-(blue2-redMiddle);
      }
      if(yellow1>redMiddle) {
        yellow1 = redMiddle-(yellow1-redMiddle);
      }
      if(yellow2>redMiddle) {
        yellow2 = redMiddle-(yellow2-redMiddle);
      }
      if(blue1!=blue2) {
        double blueMiddle = (blue1 + blue2)/2;
        if(end-blueMiddle < blueMiddle-start) {
          end = blueMiddle;
          if(yellow1>blueMiddle) {
            yellow1 = blueMiddle-(yellow1-blueMiddle);
          }
          if(yellow2>blueMiddle) {
            yellow2 = blueMiddle-(yellow2-blueMiddle);
          }
          if(yellow1!=yellow2) {
            double yellowMiddle = (yellow1 + yellow2)/2;
            if(end-yellowMiddle < yellowMiddle-start) {
              end = yellowMiddle;
            } else {
              start = yellowMiddle;
            }
          }
        } else {
          start = blueMiddle;
          if(yellow1<blueMiddle) {
            yellow1 = blueMiddle + (blueMiddle-yellow1);
          }
          if(yellow2<blueMiddle) {
            yellow2 = blueMiddle + (blueMiddle-yellow2);
          }
          if(yellow1!=yellow2) {
            double yellowMiddle = (yellow1 + yellow2)/2;
            if(end-yellowMiddle < yellowMiddle-start) {
              end = yellowMiddle;
            } else {
              start = yellowMiddle;
            }
          }
        }
      } else {
        if(yellow1!=yellow2) {
          double yellowMiddle = (yellow1 + yellow2)/2;
          if(end-yellowMiddle < yellowMiddle-start) {
            end = yellowMiddle;
          } else {
            start = yellowMiddle;
          }
        }
      }
    } else {
      start = redMiddle;
      if(blue1<redMiddle) {
        blue1 = redMiddle + (redMiddle-blue1);
      }
      if(blue2<redMiddle) {
        blue2 = redMiddle + (redMiddle-blue2);
      }
      if(yellow1<redMiddle) {
        yellow1 = redMiddle + (redMiddle-yellow1);
      }
      if(yellow2<redMiddle) {
        yellow2 = redMiddle + (redMiddle-yellow2);
      }
      if(blue1!=blue2) {
        double blueMiddle = (blue1 + blue2)/2;
        if(end-blueMiddle < blueMiddle-start) {
          end = blueMiddle;
          if(yellow1>blueMiddle) {
            yellow1 = blueMiddle - (yellow1-blueMiddle);
          }
          if(yellow2>blueMiddle) {
            yellow2 = blueMiddle - (yellow2-blueMiddle);
          }
          if(yellow1!=yellow2) {
            double yellowMiddle = (yellow1 + yellow2)/2;
            if(end-yellowMiddle < yellowMiddle-start) {
              end = yellowMiddle;
            } else {
              start = yellowMiddle;
            }
          }
        } else {
          start = blueMiddle;
          if(yellow1<blueMiddle) {
            yellow1 = blueMiddle + (blueMiddle-yellow1);
          }
          if(yellow2<blueMiddle) {
            yellow2 = blueMiddle + (blueMiddle-yellow2);
          }
          if(yellow1!=yellow2) {
            double yellowMiddle = (yellow1 + yellow2)/2;
            if(end-yellowMiddle < yellowMiddle-start) {
              end = yellowMiddle;
            } else {
              start = yellowMiddle;
            }
          }
        }
      } else {
        if(yellow1!=yellow2) {
          double yellowMiddle = (yellow1 + yellow2)/2;
          if(end-yellowMiddle < yellowMiddle-start) {
            end = yellowMiddle;
          } else {
            start = yellowMiddle;
          }
        }
      }
    }
//    System.out.println("red1:"+red1);
//    System.out.println("red2:"+red2);
//    System.out.println("blue1: "+blue1);
//    System.out.println("blue2: "+blue2);
//    System.out.println("yellow1: "+yellow1);
//    System.out.println("yellow2: "+yellow2);
//    System.out.println("end: "+exnd);
//    System.out.println("start: "+start);
    System.out.println(end-start);
    // 줄자 길이는 양 끝에서 redMiddle까지의 거리 중 긴 거리
//    if(blue1>redMiddle) {
//      blue1 = redMiddle-(blue1-redMiddle);
//    } else if(blue1<redMiddle) {
//      blue1 = redMiddle+(redMiddle-blue1);
//    }
//    if(blue2>redMiddle) {
//      blue2 = redMiddle-(blue2-redMiddle);
//    } else if(blue2<redMiddle) {
//      blue2 = redMiddle+(blue2-redMiddle);
//    }
//    if(yellow1>redMiddle) {
//      yellow1 = redMiddle-(yellow1-redMiddle);
//    } else if(yellow1<redMiddle) {
//      yellow1 = redMiddle+(yellow1-redMiddle);
//    }
//    if(yellow2>redMiddle) {
//      yellow2 = redMiddle-(yellow2-redMiddle);
//    } else if(yellow2<redMiddle) {
//      yellow2 = redMiddle+(yellow2-redMiddle);
//    }
//    if(blue1!=blue2) {
//      double blueMiddle = (blue1 + blue2)/2;
//      if(end-blueMiddle < blueMiddle) {
//        end = blueMiddle;
//      } else {
//        start = blueMiddle;
//      }
//      if(yellow1>blueMiddle) {
//        yellow1 = blueMiddle-(yellow1-blueMiddle);
//      } else if(yellow1<blueMiddle) {
//        yellow1 = blueMiddle+(yellow1-blueMiddle);
//      }
//      if(yellow2>blueMiddle) {
//        yellow2 = blueMiddle-(yellow2-blueMiddle);
//      } else if(yellow2<blueMiddle) {
//        yellow2 = blueMiddle+(yellow2-blueMiddle);
//      }
//
//    }

  }
}
