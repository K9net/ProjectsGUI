import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicalPlayer3 {
    static JFrame f = new JFrame("Первый музыкальный клип");
    static MyDrawPanel3 m1;

    public static void main(String[] args) {
        MiniMusicalPlayer3 mini = new MiniMusicalPlayer3();
        mini.go();
    }

    public void setUpGui() {
        m1 = new MyDrawPanel3();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(m1);
        f.setBounds(30, 30, 500, 500);
        f.setVisible(true);
    }

    public void go() {
        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(m1, new int[]{127});
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();
            int r;
            for (int i = 0; i < 60; i += 2) {
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(220);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    static class MyDrawPanel3 extends JPanel implements ControllerEventListener {
        boolean msg = false;

        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            if (msg) {
                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);

                g.setColor(new Color(r, gr, b));

                int ht = (int) ((Math.random() * 350) + 10);
                int wd = (int) ((Math.random() * 350) + 10);

                int x = (int) ((Math.random() * 100) + 10);
                int y = (int) ((Math.random() * 100) + 10);

                g.fillRect(x, y, wd, ht);
                msg = false;
            }
        }
    }

}
