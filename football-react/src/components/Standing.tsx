import {

    useEffect,

    useState

} from "react";




import type {

    StandingRow

} from "../types";




import {

    getStanding

} from "../services/tournamentService";









interface Props {


    tournamentId: number | null;


}









function Standing(

    { tournamentId }: Props

){







    const [standing, setStanding] =

        useState<StandingRow[]>([]);










    useEffect(()=>{






        async function loadStanding(

            id:number

        ){





            try{



                const data =

                    await getStanding(

                        id

                    );





                setStanding(

                    data

                );




            }


            catch(error){



                console.log(

                    error

                );



            }




        }









        if(

            tournamentId !== null

        ){



            loadStanding(

                tournamentId

            );



        }







    }, [tournamentId]);












    return(




        <div className="card p-4">








            <h2>


                ⚽ Classifica torneo


            </h2>










            <table className="table table-hover">








                <thead>




                <tr>




                    <th>

                        Posizione

                    </th>






                    <th>

                        Squadra

                    </th>






                    <th>

                        Punti

                    </th>





                </tr>





                </thead>









                <tbody>






                {


                    standing.map(


                        (row,index)=>(






                            <tr key={index}>






                                <td>


                                    🏅 {index + 1}


                                </td>







                                <td>


                                    {row.teamName}


                                </td>







                                <td>


                                    {row.points}


                                </td>






                            </tr>






                        )


                    )


                }







                </tbody>








            </table>








        </div>




    );





}








export default Standing;