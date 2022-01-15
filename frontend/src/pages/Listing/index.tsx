import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";

function Listing(): any {
    return (
        <>
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