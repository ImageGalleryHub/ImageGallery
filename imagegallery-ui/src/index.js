import { render } from 'react-dom';
import React from 'react';
import { Provider } from 'react-redux';
import registerServiceWorker from './registerServiceWorker';

import App from './app/containers/App';
import store from './store';

render(
  <Provider store={store}>
    <App />
  </Provider>,
  window.document.getElementById('root')
);
registerServiceWorker();
