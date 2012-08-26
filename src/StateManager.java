
public class StateManager {
   public static State currentState = new GameplayState(); // Should ultimately start as title, but for now GameplayState
   
   public static State getCurrentState(){
	   return currentState;
   }
   
   public static void TitleScreen(){
	   
   }
   
   public static void Loading(){
	   
   }
   
   public static void StartGameplay(){
	   
   }
   
   public static void CutScene(){
	   
   }
   
   public static void Pause(){
	   
   }
}
