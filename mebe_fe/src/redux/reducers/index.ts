import { combineReducers } from 'redux'
import AuthReducer from './authReducers';



const Reducers = combineReducers({
  AuthReducer,
})
export type RootState = ReturnType<typeof Reducers>;
export default Reducers
