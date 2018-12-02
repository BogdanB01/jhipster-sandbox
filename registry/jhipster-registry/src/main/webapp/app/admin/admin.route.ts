import { Routes } from '@angular/router';
import { docsRoute, healthRoute, logfileRoute, logsRoute } from './';
import { UserRouteAccessService } from 'app/shared';

const ADMIN_ROUTES = [docsRoute, healthRoute, logfileRoute, logsRoute];

export const adminState: Routes = [
    {
        path: '',
        data: {
            authorities: ['ROLE_ADMIN']
        },
        canActivate: [UserRouteAccessService],
        children: ADMIN_ROUTES
    }
];
