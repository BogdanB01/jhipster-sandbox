import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JHipsterRegistrySharedModule } from 'app/shared';

import {
    adminState,
    LogsComponent,
    JhiHealthModalComponent,
    JhiHealthCheckComponent,
    JhiConfigurationComponent,
    JhiDocsComponent,
    JhiConfigurationService,
    JhiLogfileComponent,
    JhiHealthService,
    LogsService,
    JhiLogfileService
} from './';

@NgModule({
    imports: [JHipsterRegistrySharedModule, RouterModule.forChild(adminState)],
    declarations: [
        LogsComponent,
        JhiConfigurationComponent,
        JhiDocsComponent,
        JhiHealthCheckComponent,
        JhiHealthModalComponent,
        JhiLogfileComponent
    ],
    entryComponents: [JhiHealthModalComponent],
    providers: [JhiConfigurationService, JhiHealthService, LogsService, JhiLogfileService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JHipsterRegistryAdminModule {}
