
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class SquarePanel extends JPanel {

    private int row;
    String column;
    private Jogador cg;
    private JLabel imageLabel;
    private static Image pieceImage[][] = new Image[2][6];
    private static String imageFilename[][] = {
        {"wp.gif", "wn.gif", "wb.gif", "wr.gif", "wq.gif", "wk.gif"},
        {"bp.gif", "bn.gif", "bb.gif", "br.gif", "bq.gif", "bk.gif"}};

    //colors: 0 - white; 1 - black;
    //pieces: 0 - pawn(pe�o); 1 - knight(cavalo); 2 - bishop(bispo)
    //        3 - rook(torre); 4 - queen(rainha); 5 - king(rei)
    public SquarePanel(int x, String y, Jogador c) {
        row = x;
        column = y;
        cg = c;
        setPreferredSize(new Dimension(42, 42));
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(32, 32));
        add(imageLabel);
        //loadPieceImages();
        addMouseListener(new SquareMouseListener());
    }

    public static void loadPieceImages() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                pieceImage[i][j] = Toolkit.getDefaultToolkit().getImage("./src/images/" + imageFilename[i][j]);
            }
        }
    }

    public void setBackColor(int color) {
        if (color == 0) {
            setBackground(Color.white);
        } else {
            setBackground(Color.gray);
        }
    }

    public void setPiece(int color, int type) {
        imageLabel.setIcon(new ImageIcon(pieceImage[color][type]));
    }

    public void removePiece() {
        imageLabel.setIcon(null);
    }

    class SquareMouseListener extends MouseAdapter {

        public void mouseExited(MouseEvent e) {
            setBorder(null);
        }

        public void mousePressed(MouseEvent e) {
            try {
                cg.selected(row, column);
            } catch (RemoteException ex) {
                Logger.getLogger(SquarePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            setBorder(BorderFactory.createLineBorder(Color.RED, 2));

        }

    }

}
