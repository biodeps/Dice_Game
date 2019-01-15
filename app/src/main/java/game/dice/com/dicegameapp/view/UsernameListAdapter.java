package game.dice.com.dicegameapp.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import game.dice.com.dicegameapp.R;

public class UsernameListAdapter extends RecyclerView.Adapter<UsernameListAdapter.ViewHolderData> {

    ArrayList<UserCharacter> userArrayList; // creo la lista de usuarios que se pondrá en el recycleview

    public UsernameListAdapter(ArrayList<UserCharacter> userArrayList) {
        this.userArrayList = userArrayList;
    }



    @Override
    public ViewHolderData onCreateViewHolder(ViewGroup parent, int viewType) { // enlaza el adaptador con el archivo username_list
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.username_list, null, false);
        //arriba he inflado el view con el contenido del layout y abajo lo retorno:
        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderData holder, int position) {
        //establece la comunicación entre nuestro adaptador y el ViewHolderData: Asigna los datos
        holder.name.setText(userArrayList.get(position).getName());
        holder.info.setText(userArrayList.get(position).getInfo());
        //holder.avatar.setImageResource(userArrayList.get(position).getPicture());
    }

    @Override
    public int getItemCount() { // ha de retornar el tamaño de la lista
        return userArrayList.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {

        TextView name, info;
        ImageView avatar;

        public ViewHolderData(View itemView) {
            super(itemView); // Constructor
            name = itemView.findViewById(R.id.textUsername);
            info = itemView.findViewById(R.id.textDescription);
            avatar = itemView.findViewById(R.id.imageUserAvatar);
        }

    }
}
