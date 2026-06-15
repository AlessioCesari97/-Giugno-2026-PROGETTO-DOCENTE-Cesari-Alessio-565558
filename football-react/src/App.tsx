import {

  useState

} from "react";





import TournamentSelector

  from "./components/TournamentSelector";





import Standing

  from "./components/Standing";





import "./App.css";









function App(){






  const [tournamentId,setTournamentId] =

      useState<number | null>(null);










  return(




      <div>







        <nav className="navbar navbar-dark bg-dark">


          <div className="container">


                    <span className="navbar-brand">


                        ⚽ Football Manager


                    </span>



          </div>


        </nav>











        <div className="container mt-5">





          <TournamentSelector

              onSelect={setTournamentId}

          />






          <Standing

              tournamentId={tournamentId}

          />





        </div>





      </div>



  );



}







export default App;