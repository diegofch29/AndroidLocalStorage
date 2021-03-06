package co.edu.eci.ieti.android.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import co.edu.eci.ieti.R;
import co.edu.eci.ieti.android.network.model.Task;

public abstract class TaskAdapter
    extends RecyclerView.Adapter<TaskAdapter.ViewHolder>
{

    List<Task> taskList = null;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType )
    {
        return new ViewHolder( LayoutInflater.from( parent.getContext() ).inflate( R.layout.task_row, parent, false ) );
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position )
    {
        Task task = taskList.get( position );
        holder.priorityText.setText(String.valueOf(task.getPriority()));
        holder.dueDateText.setText(task.getDueDate().toString());
        holder.descriptionText.setText(task.getDescription());
    }

    @Override
    public int getItemCount()
    {
        return taskList != null ? taskList.size() : 0;
    }
 
     public void updateTasks(List<Task> tasks){
         this.taskList = tasks;
         notifyDataSetChanged();
     }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView descriptionText,priorityText,dueDateText;
        ViewHolder( @NonNull View itemView )
        {
            super( itemView );
            dueDateText = itemView.findViewById(R.id.taskDueDate);
            descriptionText = itemView.findViewById(R.id.taskDescription);
            priorityText = itemView.findViewById(R.id.taskPriority);
        }
    }

}