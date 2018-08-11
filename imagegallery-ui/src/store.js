import { createStore, combineReducers, applyMiddleware } from 'redux';
import logger from 'redux-logger';
import thunk from 'redux-thunk';
import { reducer as formReducer } from 'redux-form';
import promise from 'redux-promise-middleware';

import math from './app/reducers/mathReducer';
import user from './app/reducers/userReducer';
import login from './app/reducers/loginReducer';

export default createStore(
  combineReducers({
    math,
    user,
    login,
    form: formReducer
  }),
  {},
  applyMiddleware(thunk, promise())
);
