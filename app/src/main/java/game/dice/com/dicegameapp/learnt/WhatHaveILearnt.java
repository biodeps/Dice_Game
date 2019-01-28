/*                        TODO This is only to gather all the learnt things during the project


TODO BASICS

    La capa VIEW és la capa API, la que connecta amb l'usuari. Si algo es relaciona amb l'usuari, ha d'anar si o si en aquesta capa.

    Importante: En cada una de las Activities en las que necesite pasar datos, declararé un new GameController().
    La gracia de esto es que, al ser sus campos players y currentPlayer statics, no se machacarán, y se podrán utilizar
    y visualizar desde cada una de las Activities. Esta declaración de un new GameController() genera un objeto
    GameController nuevo, pero la gracia es que algunos de sus campos son statics y se reutilizarán entre activities.



TODO HOW TO SEND OBJECTS BETWEEN ACTIVITIES (PSEUDOCODE) ----- READ CAREFULLY

    One option could be letting your custom class implement the Serializable interface and then you can pass object instances in the intent extra using the putExtra(Serializable..) variant of the Intent#putExtra() method.

    Pseudocode:

    //To pass:
    intent.putExtra("MyClass", obj);

    // To retrieve object in second Activity
    (CastClass) getIntent().getSerializableExtra("MyClass"); El casteo es necesario con la clase CastClass (Player, Game...)

    Note: Make sure each nested class of your main custom class has implemented Serializable interface to avoid any serialization exceptions. For example:

    class MainClass implements Serializable {

        public MainClass() {}

        public static class ChildClass implements Serializable {

            public ChildClass() {}
        }
    }


TODO COMPARE FLOATS USING COMPARATORS (toCompare)
    https://stackoverflow.com/questions/3705275/help-comparing-float-member-variables-using-comparators


TODO HOW TO SORT A LIST? (NOT WORKING WITH ARRAYLISTS OF OBJECTS)

    Collections.sort(myList, new Comparator<EmployeeClass>(){
        public int compare(EmployeeClass obj1, EmployeeClass obj2) {
            // ## Ascending order
            return obj1.firstName.compareToIgnoreCase(obj2.firstName); // To compare string values
            // return Integer.valueOf(obj1.empId).compareTo(Integer.valueOf(obj2.empId)); // To compare integer values

            // ## Descending order
            // return obj2.firstName.compareToIgnoreCase(obj1.firstName); // To compare string values
            // return Integer.valueOf(obj2.empId).compareTo(Integer.valueOf(obj1.empId)); // To compare integer values
            }
        });


TODO Inflar el Layout y setear el holder

    @Override
    public ViewHolderData onCreateViewHolder(ViewGroup parent, int viewType) { // TODO enlaza el adaptador con el archivo username_list
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.username_list, null, false);
        view.setOnClickListener(this); // TODO para que pueda escuchar el evento de selección
        // TODO arriba he inflado el view con el contenido del layout y abajo lo retorno:
        return new ViewHolderData(view);
    }



TODO Añadir eventos onClick a la Recycler

    @Override
        public void onClick(View view) { // TODO para esto hace falta el implements View.OnClickListener
                                         // TODO en cabecera. Añade eventos onClick a los elementos de la recycler
            if (listener != null) {
                listener.onClick(view);
            }
        }

TODO Definir evento onClick en Recycler
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }


TODO Crear clase ViewHolder para alimentar la Recycler view

    public static class ViewHolderData extends RecyclerView.ViewHolder {

        TextView name, info;
        ImageView avatar;

        public ViewHolderData(View itemView) {
            super(itemView); // Constructor
            name = itemView.findViewById(R.id.textUsername);
            info = itemView.findViewById(R.id.textDescription);
            avatar = itemView.findViewById(R.id.imageUserAvatar);
            // TODO Con estas referencias ya podemos empezar a alimentar la Recycler View
        }

    }

TODO Comunicación entre adaptador y viewholder

    @Override
    public void onBindViewHolder(ViewHolderData holder, int position) {
        // TODO establece la comunicación entre nuestro adaptador y el ViewHolderData: Asigna los datos
        holder.name.setText(userArrayList.get(position).getName());
        holder.info.setText(userArrayList.get(position).getAverageScore());
        holder.avatar.setImageResource(R.drawable.user_avatar); // TODO Random avatar para futuras ampliaciones
    }

TODO Override necesario que devuelva el tamaño de la lista
    @Override
    public int getItemCount() { // TODO ha de retornar el tamaño de la lista
        return userArrayList.size();
    }


TODO En la activity (Java) que voy a llamar a la Recycler:

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        userArrayList = new ArrayList<>();
        // TODO le linkeo la recyclerView
        recyclerPlayers = findViewById(R.id.recyclerId);
        // TODO forma de presentar los datos
        recyclerPlayers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        // TODO 2 pasos finales:
        adapter = new UsernameListAdapter(userArrayList);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // TODO implementación del método onClick que he generado en mi adaptador
                String currentUserName = userArrayList.get(recyclerPlayers.getChildAdapterPosition(view)).getName(); // TODO String del currentUserName
                for (Player p: userArrayList) {
                    if (p.getName().equals(currentUserName)) { // TODO encuentro el usuario con el que voy a jugar, y lo asigno
                        currentGame.setCurrentPlayer(p);
                    }
                }
                Intent newGameIntent = new Intent(getApplicationContext(), PlayGameActivity.class);
                startActivity(newGameIntent);
            }
        });

        recyclerPlayers.setAdapter(adapter);
        fillAllPlayers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


    private void fillAllPlayers(){
        userArrayList.addAll(currentGame.getPlayersList());
        adapter.notifyDataSetChanged(); // TODO notifica que s'ha modificat l'arraylist i actualitza automàticament
    }





 */