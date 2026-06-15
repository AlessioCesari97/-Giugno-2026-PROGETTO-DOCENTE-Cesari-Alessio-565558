import {

    useEffect,

    useState

} from "react";




import  type {

    Tournament

} from "../types";





import {

    getTournaments

} from "../services/tournamentService";








interface Props {


    onSelect:

        (id:number)=>void;


}









function TournamentSelector(

    {onSelect}:Props

){





    const [tournaments,setTournaments] =

        useState<Tournament[]>([]);










    useEffect(()=>{





        async function load(){



            try{



                const data =

                    await getTournaments();




                setTournaments(data);





                if(data.length>0){



                    onSelect(

                        data[0].id

                    );



                }



            }



            catch(error){


                console.log(error);


            }




        }






        load();




    },[]);











    return(



        <div className="card p-4 mb-4">






            <h2>

                🏆 Seleziona torneo

            </h2>







            <select

                className="form-select"


                onChange={

                    e =>

                        onSelect(

                            Number(e.target.value)

                        )

                }>








                {

                    tournaments.map(


                        tournament => (



                            <option

                                key={tournament.id}

                                value={tournament.id}>


                                {tournament.name}


                            </option>



                        )


                    )


                }






            </select>





        </div>



    );



}






export default TournamentSelector;