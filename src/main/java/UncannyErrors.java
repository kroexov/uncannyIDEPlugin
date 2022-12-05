import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.roots.CollectingContentIterator;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vcs.CodeSmellDetector;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UncannyErrors extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        var projects = ProjectManager.getInstance().getOpenProjects();
        var collection = new ArrayList<VirtualFile>();
        ProjectFileIndex.getInstance(projects[0]).iterateContent(new CollectingContentIterator() {
            @Override
            public @NotNull List<VirtualFile> getFiles() {
                return null;
            }

            @Override
            public boolean processFile(@NotNull VirtualFile fileOrDir) {
                collection.add(fileOrDir);
                return true;
            }
        });
        var smells = CodeSmellDetector.getInstance(projects[0]).findCodeSmells(collection);
        var numOfErrros = "You have " + (smells.size()-1) + " errors";
        var returner = "Good!";
        var description = "";
        Icon icon = MyIcons.Canny1;
        if (smells.size() < 2){
            description = "Canny";
        }
        if (smells.size() >= 2){
            description = "Not canny";
            returner = "OK...";
            icon = MyIcons.Canny2;
        }
        if (smells.size() >= 5){
            description = "Uncanny";
            returner = "Damn";
            icon = MyIcons.Canny3;
        }
        if (smells.size() >= 10){
            description = "Very uncanny";
            returner = "Oh no!";
            icon = MyIcons.Canny4;
        }
        if (smells.size() >= 20){
            description = "Stop this!";
            returner = "This is not good...";
            icon = MyIcons.Canny5;
        }
        if (smells.size() >= 50){
            description = "You are fired";
            returner = "No God please no!";
            icon = MyIcons.Canny6;
        }
        String[] options = new String[]{
                returner
        };
        Messages.showDialog(numOfErrros, description, options, 0, icon);
        //Messages.showMessageDialog(numOfErrros, description, icon);
    }

    @Override
    public boolean isDumbAware() {
        return super.isDumbAware();
    }
}
