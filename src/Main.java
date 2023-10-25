public class Main {
    private static int state = 0;
    private static Thread mainThread;

    private static MainMenu menu;
    private static Window window;

    public static void main(String[] args) {

        menu = new MainMenu();
        mainThread = new Thread(menu);
        mainThread.start();
    }

    public static void changeState(int newState) {
        if (newState == 1 && state == 0) {//menu stop, game start
            menu.stop();
            window = new Window();
            mainThread=new Thread(window);
            mainThread.start();
        }else if(newState==0&& state==1){//game stop, manu start
            window.stop();
            menu = new MainMenu();
            mainThread =new Thread(menu);
            mainThread.start();
        }else if(newState==2){
            if(window!=null){
                window.stop();
            }
            if(menu!=null){
                menu.stop();
            }

        }
        state = newState;
    }


}