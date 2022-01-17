import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/request";

function Listing(): any {

    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    const [pageNumber, setPageNumber] = useState(0)

    const [page, setPage] = useState<MoviePage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 12,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    })

    useEffect(() => {
        // page especifica o número da página
        // sort=title ordena os filmes por titulo
        axios.get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=title`)
            .then(response => {
                const data = response.data as MoviePage
                setPage(data);
            })

    }, [pageNumber])

    // Muda o número da página
    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber)
    }

    return (

        <>
            <Pagination page={page} onChange={handlePageChange} />

            <div className="container">
                <div className="row">
                    {/* Permite definir o que será executado para cada item do array */}
                    {page.content.map(movie => (

                        <div className="col-sm-6 col-lg-4 col-xl-3 mb-3" >
                            <MovieCard movie={movie} />
                        </div>

                    ))}
                </div>
            </div>

        </>
    );
}

export default Listing;