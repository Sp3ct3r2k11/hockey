/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.game.core;

import id.game.objects.Box;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Lenovo
 */
public class KeyHandler extends KeyAdapter {
    public ObjectHandler handler;
    
    public KeyHandler(ObjectHandler handler) {
        this.handler = handler;
    }

    @Override
    public void keyReleased(KeyEvent e) { //tombol dilepas
        super.keyReleased(e);
        handler.removeKey(e.getKeyCode());
        
        for(GameObject object:handler.objects){
            if(object.getType() == GameObject.ObjectType.PLAYER){
                Box box = (Box) object;

                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){
                    box.velY = 0;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT){
                    box.velX = 0;
                }
            }
//            else 
//                if(object.getType() == 2){
//                Box box = (Box) object;
//                if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S){
//                    box.velY = 0;
//                }
//            }
        }
//        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) { //tombol dipencet
        super.keyPressed(e); 
        handler.addKey(e.getKeyCode());
//        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) { //pencet angkat cepet
        super.keyTyped(e); 
        System.out.println(e.getKeyCode());
    }
     
    public void tick(){
        for(GameObject object: handler.objects){
            if(object.getType() == GameObject.ObjectType.PLAYER){
                Box box = (Box) object;
                for(int key:handler.keys){
                    if(key == KeyEvent.VK_UP){
                        box.velY = -5;
                    }

                    if(key == KeyEvent.VK_DOWN){
                        box.velY = 5;
                    }
                    
                    if(key == KeyEvent.VK_RIGHT){
                        box.velX = 5;
                    }

                    if(key == KeyEvent.VK_LEFT){
                        box.velX = -5;
                    }
                }
            }
//            else if(object.getType() == GameObject.TYPE_BOX2){
//                Box box = (Box) object;
//                for(int key:handler.keys){
//                    if(key == KeyEvent.VK_W){
//                        box.velY = -5;
//                    }
//
//                    if(key == KeyEvent.VK_S){
//                        box.velY = 5;
//                    }
//                }
//            }
        }
    }
}
