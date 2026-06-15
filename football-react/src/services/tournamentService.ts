import api from "./api";



import type {

    Tournament,

    StandingRow

} from "../types";









export async function getTournaments()

    :Promise<Tournament[]> {





    const response =

        await api.get<Tournament[]>(

            "/tournaments"

        );





    return response.data;


}










export async function getStanding(

    tournamentId:number

):Promise<StandingRow[]> {





    const response =

        await api.get<StandingRow[]>(


            `/tournaments/${tournamentId}/standing`


        );






    return response.data;



}