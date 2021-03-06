package lollipop.services.movies;

import javax.inject.Inject;

import io.vertigo.commons.transaction.Transactional;
import io.vertigo.dynamo.criteria.Criterions;
import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtListState;
import lollipop.dao.movies.MovieDAO;
import lollipop.domain.movies.Movie;

@Transactional
public class MovieServicesImpl implements MovieServices {

	@Inject
	private MovieDAO movieDAO;

	@Override
	public Movie get(final Long movId) {
		return movieDAO.get(movId);
	}

	@Override
	public void save(final Movie movie) {
		movieDAO.save(movie);
	}

	@Override
	public DtList<Movie> getMovies(final DtListState dtListState) {
		return movieDAO.findAll(Criterions.alwaysTrue(), dtListState.getMaxRows().orElse(50));
	}
}
