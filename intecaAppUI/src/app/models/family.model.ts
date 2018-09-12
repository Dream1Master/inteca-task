import { Child } from './child.model';
import { Father } from './father.model';
export class Family {

  id: number;
  father: Father;
  children: Array<Child>;
}
