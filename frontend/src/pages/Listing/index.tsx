import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/request";

function Listing(): any {

    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    const [pageNumber, setPageNumber] = useState(0)

    useEffect(() => {
        // page especifica o número da página
        axios.get(`${BASE_URL}/movies?size=12&page=1`)
            .then(response => {
                const data = response.data as MoviePage
                console.log(data)
                setPageNumber(data.number)
            })

    }, [])


    return (

        <>
            <p>{pageNumber}</p>
            <Pagination />

            <div className="container">
                <div className="row">

                    {/* Quantidade de cards para cada dimensão de tela */}
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>



                </div>
            </div>

        </>
    );
}

export default Listing;